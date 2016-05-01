import java.util.*;
import java.math.*;
public class multiply_bignum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			String a = in.next();
			String b = in.next();

			BigInteger aa = new BigInteger(a);
			BigInteger bb = new BigInteger(b);

			System.out.println(aa.multiply(bb).toString());
		}
	}
}