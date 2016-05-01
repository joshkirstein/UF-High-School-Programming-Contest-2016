import java.util.*;
import java.io.*;

class ekg_cormac {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		int cases = in.nextInt();

		while (cases-->0) {
			String line = in.next();
			int lastR = -1;
			int time = -1;

			boolean regular = true;

			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (c == 'R') {
					if (lastR != -1) {
						int dist = i - lastR;
						if (time == -1) {
							time = dist;
						} else if (time != dist) {
							regular = false;
							break;
						}
					}

					lastR = i;
				}
			}

			if (regular) {
				System.out.println("Regular");
			} else {
				System.out.println("Irregular");
			}
		}
	}
}