import java.util.*;
//joshua kirstein, random generator for polygonal integral
public class polyint_gen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = 1000;
		gen_util.emit_ln(cases);
		for (int i = 0; i < cases; i++) {
			int numPoints = 2+gen_util.rnd.nextInt(100);
			gen_util.emit_ln(numPoints);
			int seedX = gen_util.rnd.nextInt(100);
			int seedY = gen_util.rnd.nextInt(10000);
			gen_util.emit_ln(seedX + " " + seedY);
			for (int j = 0; j < numPoints-1; j++) {
				int newX = seedX+gen_util.rnd.nextInt(5)+1;
				int newY = gen_util.rnd.nextInt(10000);
				gen_util.emit_ln(newX + " " + newY);
				seedX = newX;
				seedY = newY;
			}
		}
	}
}
class gen_util {
	static Random rnd = new Random();
	static void emit_ln(Object i) {
		System.out.println(i);
	}
}