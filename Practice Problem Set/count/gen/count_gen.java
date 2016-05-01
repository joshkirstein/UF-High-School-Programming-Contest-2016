import java.util.*;

public class count_gen {
	static Random rnd = new Random();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = 100;
		System.out.println(cases);
		for (int i = 0; i < cases; i++) {
			int numchars = 1+rnd.nextInt(80);
			String out = "";
			for (int j = 0; j < numchars; j++) {
				out += (char) ('a' + rnd.nextInt(26));
			}
			System.out.println(out);
		}
	}
}