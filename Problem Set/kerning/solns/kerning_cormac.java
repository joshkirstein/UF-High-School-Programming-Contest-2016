import java.util.*;
import java.io.*;

class kerning_cormac {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		int cases = in.nextInt();

		while (cases-->0) {
			int rows = in.nextInt();
			int cols = in.nextInt();

			char[][] grid = new char[rows][cols];

			for (int i = 0; i < rows; i++) {
				String line = in.next();
				for (int j = 0; j < cols; j++) {
					grid[i][j] = line.charAt(j);
				}
			}

			boolean foundGlyph = false;

			List<Point> glyph1 = new ArrayList<Point>();
			List<Point> glyph2 = new ArrayList<Point>();

			boolean[][] visited = new boolean[rows][cols];

			int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
			int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (grid[i][j] == '1' && !visited[i][j]) {
						if (!foundGlyph) {
							foundGlyph = true;

							Queue<Point> queue = new LinkedList<Point>();
							queue.add(new Point(i, j));
							visited[i][j] = true;

							while (!queue.isEmpty()) {
								Point point = queue.remove();
								glyph1.add(point);
								for (int k = 0; k < 8; k++) {
									int x = point.x + dx[k];
									int y = point.y + dy[k];
									if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1' && !visited[x][y]) {
										visited[x][y] = true;
										queue.add(new Point(x, y));
									}
								}
							}
						}  else {
							Queue<Point> queue = new LinkedList<Point>();
							queue.add(new Point(i, j));
							visited[i][j] = true;

							while (!queue.isEmpty()) {
								Point point = queue.remove();
								glyph2.add(point);
								for (int k = 0; k < 8; k++) {
									int x = point.x + dx[k];
									int y = point.y + dy[k];
									if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1' && !visited[x][y]) {
										visited[x][y] = true;
										queue.add(new Point(x, y));
									}
								}
							}
						}
					}
				}
			}

			int minDistance = Integer.MAX_VALUE;

			for (Point p : glyph1) {
				for (Point pp : glyph2) {
					int x = p.x - pp.x;
					int y = p.y - pp.y;
					int dist = x*x + y*y;
					minDistance = Math.min(minDistance, dist);
				}
			}

			System.out.println(minDistance);
		}
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}