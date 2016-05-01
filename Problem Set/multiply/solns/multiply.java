import java.util.*;

public class multiply {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			String a = in.next();
			String b = in.next();

			int aa = Integer.parseInt(a.substring(0, 1));
			int bb = Integer.parseInt(b.substring(0, 1));

			int d = aa * bb;

			int a0 = a.length() - 1;
			int b0 = b.length() - 1;

			System.out.print(d);
			for (int j = 0; j < (a0 + b0); j++) System.out.print(0);
			System.out.println();
		}
	}
}