import java.util.*;
//joshua kirstein, soln for dispatch roster
//this is brute force and hence not supposed to be accepted
public class DispatchRoster_bf {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while (cases-->0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] sum = new int[M+1];
			for (int i = 0; i < N; i++) {
				int start = sc.nextInt();
				int dur = sc.nextInt();
				int end = start+dur-1;
				int computers = sc.nextInt();
				for (int j = start; j <= end; j++) {
					sum[j] += computers;
				}
			}
			for (int i = 1; i <= M; i++) {
				if (i == 1) {
					System.out.print(sum[i]);
				} else {
					System.out.print(" " + sum[i]);
				}
			}
			System.out.println();
		}
	}
}