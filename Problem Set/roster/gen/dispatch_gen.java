import java.util.*;
//joshua kirstein, random generator for dispatch roster
public class dispatch_gen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = 1000;
		gen_util.emit_ln(cases);
		for (int i = 0; i < cases; i++) {
			int numTrucks = 1+gen_util.rnd.nextInt(100);
			int numMinutes = 1+gen_util.rnd.nextInt(100);
			gen_util.emit_ln(numTrucks, numMinutes);
			for (int j = 0; j < numTrucks; j++) {
				int startTime = 1+gen_util.rnd.nextInt(numMinutes);//[1, numMinutes]
				int length = 1+gen_util.rnd.nextInt(numMinutes+1-startTime);
				int numComps = 1+gen_util.rnd.nextInt(10);
				gen_util.emit_ln(startTime, length, numComps);
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