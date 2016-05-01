import java.util.*;
//joshua kirstein, random generator for EKG problem
public class ekg_gen {
	static char[] valid = {'P', 'Q', 'R', 'S', 'T', 'U', '-'};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = 10000;
		gen_util.emit_ln(cases);
		for (int i = 0; i < cases; i++) {
			while (true) {
				int numR = 0;
				String s = "";
				int amt = 3 + gen_util.rnd.nextInt(15);
				for (int j = 0; j < amt; j++) {
					int rndIdx = gen_util.rnd.nextInt(valid.length);
					s += valid[rndIdx];
					if (valid[rndIdx] == 'R') numR++;
				}
				if (numR >= 3) {
					gen_util.emit_ln(s);
					break;
				}
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