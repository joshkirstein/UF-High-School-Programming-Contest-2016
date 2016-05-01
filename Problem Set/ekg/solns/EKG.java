import java.util.*;
//joshua kirstein
public class EKG {
	static String ACCEPT = "Regular";
	static String REJECT = "Irregular";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while (cases-->0) {
			char[] ekg = sc.next().toCharArray();
			int last = -1;
			int dist = -1;
			boolean reject = false;
			int rCount = 0;
			for (int i = 0; i < ekg.length; i++) {
				if (ekg[i] == 'R') {
					rCount++;
					if (last == -1) {
						last = i;
					} else {
						int delta = Math.abs(last-i);
						if (dist == -1) {
							dist = delta;
						} else {
							if (dist != delta) {
								reject = true;
							} else {
								//nop, we're good
							}
						}
						last = i;
					}
				}
			}
			if (rCount < 3) throw new RuntimeException("JUDGE ERROR: Not enough R's in input!");
			if (reject) System.out.println(REJECT);
			else System.out.println(ACCEPT);
		}
	}
}