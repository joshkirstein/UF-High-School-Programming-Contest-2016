import java.util.*;

public class greater_gen {
	static Random rnd = new Random();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = 100;
		System.out.println(cases);
		for (int i = 0; i < cases; i++) {
			long x = rnd.nextLong();
			long y = rnd.nextLong();
			System.out.println(x + " " + y);
		}
	}
}