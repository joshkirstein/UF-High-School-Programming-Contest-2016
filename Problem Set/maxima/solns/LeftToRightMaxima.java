import java.util.*;
//joshua kirstein, soln to left to right maxima
public class LeftToRightMaxima {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while (cases-->0) {
			int N = sc.nextInt();
			if (N < 1 || N > 19) throw new RuntimeException("JUDGE ERROR: N not good.");
			int i = sc.nextInt();
			int j = sc.nextInt();
			if (i < 1 || i > N || j < 1 || j > N) throw new RuntimeException("JUDGE ERROR: i or j not good.");
			long factorial = 1;
			for (long fact = 1; fact <= N; fact++) {
				factorial *= fact;
			}
			if (i == j) {
				System.out.println(factorial);
			} else {
				System.out.println(factorial/2);
			}
		}
	}
}