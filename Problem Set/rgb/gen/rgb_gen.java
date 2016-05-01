import java.util.*;
//joshua kirstein, random generator for rgb
public class rgb_gen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = 100;
		gen_util.emit_ln(cases);
		//totally random
		for (int z = 0; z < cases; z++) {
			int N = 1+gen_util.rnd.nextInt(10);
			gen_util.emit_ln(N);
			int rX = gen_util.rnd.nextInt(256);
			int rY = gen_util.rnd.nextInt(256);
			int rZ = gen_util.rnd.nextInt(256);
			gen_util.emit_ln(rX, rY, rZ);
			for (int i = 0; i < N; i++) {
				rX = gen_util.rnd.nextInt(256);
				rY = gen_util.rnd.nextInt(256);
				rZ = gen_util.rnd.nextInt(256);
				gen_util.emit_ln(rX, rY, rZ);
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