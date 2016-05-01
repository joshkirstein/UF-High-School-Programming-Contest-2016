import java.util.*;
//joshua kirstein, random generator for multiply
public class multiply_gen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = 1000;
		gen_util.emit_ln(cases);
		for (int z = 0; z < cases; z++) {
			int dig1 = 1+gen_util.rnd.nextInt(9);
			int dig2 = 1+gen_util.rnd.nextInt(9);
			int numZeros1 = gen_util.rnd.nextInt(10);
			int numZeros2 = gen_util.rnd.nextInt(10);
			String s1 = "" + dig1;
			String s2 = "" + dig2;
			for (int i = 0; i < numZeros1; i++) s1 = s1 + "0";
			for (int i = 0; i < numZeros2; i++) s2 = s2 + "0";

			gen_util.emit_ln(s1, s2);
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