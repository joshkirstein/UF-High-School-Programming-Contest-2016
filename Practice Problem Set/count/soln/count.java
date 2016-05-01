import java.util.*;
public class count {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		sc.nextLine();//nextInt doesn't remove '\n'
		for (int i = 0; i < cases; i++) {
			String line = sc.nextLine().toLowerCase();
			int cnt = 0;
			for (char ch : line.toCharArray()) {
				if (ch == 'a' || ch == 'e' 
					|| ch == 'i' || ch == 'o' || ch == 'u') {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}