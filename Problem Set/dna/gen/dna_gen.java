import java.util.*;
//joshua kirstein, random generator for dna
public class dna_gen {
	static char[] chars = {'A', 'C', 'T', 'G'};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = 1000;
		gen_util.emit_ln(cases);
		for (int z = 0; z < cases; z++) {
			int numChars = 1+gen_util.rnd.nextInt(50);
			String s = "";
			for (int i = 0; i < numChars; i++) {
				s += chars[gen_util.rnd.nextInt(4)];
			}
			gen_util.emit_ln(s);
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