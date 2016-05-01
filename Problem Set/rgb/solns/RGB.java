import java.util.*;
//joshua kirstein, soln to rgb mixing
public class RGB {
	static String ACCEPT = "Yes";
	static String REJECT = "No";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while(cases-->0) {
			int N = sc.nextInt();
			int[] rs = new int[N];
			int[] gs = new int[N];
			int[] bs = new int[N];
			int goalR = sc.nextInt();
			int goalG = sc.nextInt();
			int goalB = sc.nextInt();
			for (int i = 0; i < N; i++) {
				rs[i] = sc.nextInt();
				gs[i] = sc.nextInt();
				bs[i] = sc.nextInt();
			}
			int pow = 1<<N;
			boolean works = false;
			for (int i = 0; i < pow; i++) {
				int sumR = 0;
				int sumG = 0;
				int sumB = 0;

				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) != 0) {
						sumR += rs[j];
						sumG += gs[j];
						sumB += bs[j];
					}
				}


				sumR = Math.min(sumR, 255);
				sumG = Math.min(sumG, 255);
				sumB = Math.min(sumB, 255);
				
				if (sumR == goalR 
					&& sumG == goalG 
					&& sumB == goalB) {
					works = true;
				}
			}
			if (works) System.out.println(ACCEPT);
			else System.out.println(REJECT);
		}
	}
}