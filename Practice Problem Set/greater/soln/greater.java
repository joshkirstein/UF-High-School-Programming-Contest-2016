import java.util.*;

public class greater {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for (int i = 0; i < cases; i++) {
			long x = sc.nextLong();
			long y = sc.nextLong();
			if (x > y) System.out.println("Yes");
			else System.out.println("No");
		}
	}
}