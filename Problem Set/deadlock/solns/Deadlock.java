import java.util.*;
import java.io.*;
//soln written by joshua kirstein
public class Deadlock {
    static String HAS = "Yes";
    static String DOESNT = "No";
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-->0) {
            int numProcs = sc.nextInt();
            int numLocks = sc.nextInt();
            if (numProcs < 1 || numLocks < 1 || numProcs > 1000 || numLocks > 1000)
                throw new RuntimeException("JUDGE ERROR: Invalid number of locks or procs.");
            int[][] adj = new int[numProcs][numLocks];
            boolean[] isWaiting = new boolean[numProcs];
            boolean[] isTaken = new boolean[numLocks];
            int edges = sc.nextInt();
            for (int i = 0; i < edges; i++) {
                String type = sc.next();
                int procFrom = sc.nextInt()-1;
                int lockTo = sc.nextInt()-1;
                if (adj[procFrom][lockTo] != 0)
                    throw new RuntimeException("JUDGE ERROR: Proc waiting on a lock it owns!");
                if (type.equals("L")) {
                    if (isWaiting[procFrom])
                        throw new RuntimeException("JUDGE ERROR: Proc is waiting on multiple locks!");
                    isWaiting[procFrom] = true;
                    adj[procFrom][lockTo] = 1;
                } else if (type.equals("H")) {
                    if (isTaken[lockTo])
                        throw new RuntimeException("JUDGE ERROR: Lock is held by multiple procs!");
                    isTaken[lockTo] = true;
                    adj[procFrom][lockTo] = 2;
                } else {
                    throw new RuntimeException("JUDGE ERROR: Invalid edge type!");
                }
            }
            boolean hasCycle = false;
            for (int i = 0; i < numProcs; i++) {
                hasCycle |= cycle(i, true, new boolean[numProcs+numLocks], numProcs, numLocks, adj, i);
            }

            if (hasCycle) System.out.println(HAS);
            else System.out.println(DOESNT);
        }
    }
    static boolean cycle(int id, boolean isProc, boolean[] vis, int numProcs, int numLocks, int[][] adj, int startId) {
        vis[id + (isProc?0:numProcs)] = true;
        if (isProc) {
            boolean meh = false;
            for (int i = 0; i < numLocks; i++) {
                if (adj[id][i] == 1 && !vis[i+numProcs]) {
                    meh |= cycle(i, false, vis, numProcs, numLocks, adj, startId);
                }
            }
            return meh;
        } else {
            boolean meh = false;
            for (int i = 0; i < numProcs; i++) {
                if (adj[i][id] == 2 && i == startId) return true;
                if (adj[i][id] == 2 && !vis[i]) {
                    meh |= cycle(i, true, vis, numProcs, numLocks, adj, startId);
                }
            }
            return meh;
        }
    }
}