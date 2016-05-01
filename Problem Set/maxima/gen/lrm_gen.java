import java.util.*;
//joshua kirstein, random generator for left to right maxima problem
public class lrm_gen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = 100;
		gen_util.emit_ln(cases);
		for (int i = 0; i < cases; i++) {
			int N = 1+gen_util.rnd.nextInt(19);
			int I = 1+gen_util.rnd.nextInt(N);
			int J = 1+gen_util.rnd.nextInt(N);
			gen_util.emit_ln(N, I, J);
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