import java.util.*;
//joshua kirstein
public class PolygonalIntegral {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while (cases-->0) {
			int pts = sc.nextInt();
			if (pts < 2) throw new RuntimeException("JUDGE ERROR: Not enough points!");
			if (pts > 10000) throw new RuntimeException("JUDGE ERROR: Too many points!");
			double area = 0.0;
			int prevX = sc.nextInt();
			int prevY = sc.nextInt();
			for (int i = 1; i < pts; i++) {
				int curX = sc.nextInt();
				int curY = sc.nextInt();
				if (curX > 10000 || curY > 10000) throw new RuntimeException("JUDGE ERROR: Coordinates too big.");
				if (curX <= prevX) throw new RuntimeException("JUDGE ERROR: xi >= xi+1!");

				int base = Math.abs(curX-prevX);
				int height = Math.abs(curY-prevY);
				area += 0.5*base*height;
				int squareheight = Math.min(curY, prevY);
				area += squareheight*base;

				prevX = curX;
				prevY = curY;
			}
			System.out.printf("%.2f\n", area);
		}
	}
}