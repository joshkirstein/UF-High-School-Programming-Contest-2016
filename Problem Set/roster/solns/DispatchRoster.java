import java.util.*;
//joshua kirstein, soln for dispatch roster
public class DispatchRoster {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while (cases-->0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			if (N < 1 || N > 100_000)
				throw new RuntimeException("JUDGE ERROR: type 1");
			if (M < 1 || M > 100_000)
				throw new RuntimeException("JUDGE ERROR: type 2");
			int[] deltas = new int[M+2];
			for (int i = 0; i < N; i++) {
				int start = sc.nextInt();
				int dur = sc.nextInt();
				int end = start+dur-1;
				int computers = sc.nextInt();
				if (start < 1) 
					throw new RuntimeException("JUDGE ERROR: type 3");
				if (dur < 1) 
					throw new RuntimeException("JUDGE ERROR: type 4");
				if (start+dur > M+1) 
					throw new RuntimeException("JUDGE ERROR: type 5");
				if (computers < 0 || computers > 10)
					throw new RuntimeException("JUDGE ERROR: type 6");
				deltas[start] += computers;
				deltas[end+1] -= computers;
			}
			int sum = 0;
			for (int i = 1; i <= M; i++) {
				sum += deltas[i];
				if (i == 1) {
					System.out.print(sum);
				} else {
					System.out.print(" " + sum);
				}
			}
			System.out.println();
		}
	}
}