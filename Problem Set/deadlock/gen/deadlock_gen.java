import java.util.*;
//joshua kirstein, random generator for deadlock
public class deadlock_gen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = 100;
		gen_util.emit_ln(cases);
		for (int i = 0; i < cases; i++) {
			int numProcs = 1+gen_util.rnd.nextInt(10);
			int numLocks = 1+gen_util.rnd.nextInt(10);
			gen_util.emit_ln(numProcs, numLocks);

			int[][] conn = new int[numProcs+1][numLocks+1];
			boolean[] isWaiting = new boolean[numProcs+1];
			boolean[] isTaken = new boolean[numLocks+1];

			int edges = 1+gen_util.rnd.nextInt((numProcs+numLocks)/2);
			gen_util.emit_ln(edges);
			while (edges-->0) {
				while (true) {
					int type = 1+gen_util.rnd.nextInt(2);
					//type 1 = 'L' (waiting)
					//type 2 = 'H' (has)
					int procFrom = 1+gen_util.rnd.nextInt(numProcs);
					int lockTo = 1+gen_util.rnd.nextInt(numLocks);

					//procFrom and lockTo already associated
					if (conn[procFrom][lockTo] != 0) continue;
					//this is a wait edge and proc is already waiting
					if (type == 1 && isWaiting[procFrom]) continue;
					//lock is already taken
					if (type == 2 && isTaken[lockTo]) continue;

					conn[procFrom][lockTo] = type;
					if (type == 1) isWaiting[procFrom] = true;
					if (type == 2) isTaken[lockTo] = true;

					String out = (type == 1) ? "L" : "H";
					gen_util.emit_ln(out, procFrom, lockTo);
					break;
				}
			}
		}
	}
}
class gen_util {
	static Random rnd = new Random();
	static void emit_ln(Object... arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) System.out.print(arr[i]);
			else {
				System.out.print(" ");
				System.out.print(arr[i]);
			}
		}
		System.out.println();
	}
}