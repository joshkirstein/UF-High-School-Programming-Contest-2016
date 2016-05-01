import java.util.*;
//joshua kirstein, random generator for zamboni
public class zamboni_gen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = 1000;
		gen_util.emit_ln(cases);
		for (int i = 0; i < cases; i++) {
			int rows = 1+gen_util.rnd.nextInt(100);
			int cols = 1+gen_util.rnd.nextInt(100);
			int x = gen_util.rnd.nextInt(rows);
			int y = gen_util.rnd.nextInt(cols);
			gen_util.emit_ln(rows, cols, x, y);
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