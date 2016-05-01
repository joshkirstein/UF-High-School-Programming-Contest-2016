import java.util.*;
//joshua kirstein, soln to Kerning
public class Kerning {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while (cases-->0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			if (N < 1 || M < 1 || N > 100 || M > 100)
				throw new RuntimeException("JUDGE ERROR: Dimensions not valid!");
			char[][] grid = new char[N][M];
			for (int i = 0; i < N; i++) {
				String word = sc.next();
				for (int j = 0; j < M; j++) {
					grid[i][j] = word.charAt(j);
					if (grid[i][j] != '0' && grid[i][j] != '1') {
						throw new RuntimeException("JUDGE ERROR: Input doesn't have 0 or 1!");
					}
				}
			}
			ArrayList<Point> groupone = null;
			ArrayList<Point> grouptwo = null;
			boolean[][] visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j] && grid[i][j] == '1') {
						ArrayList<Point> grouptoadd;
						if (groupone == null) {
							groupone = new ArrayList<Point>();
							grouptoadd = groupone;
						} else if (grouptwo == null) {
							grouptwo = new ArrayList<Point>();
							grouptoadd = grouptwo;
						} else {
							throw new RuntimeException("JUDGE ERROR: Input has too many glyphs!");
						}
						dfs(i, j, grouptoadd, visited, grid);
					}
				}
			}
			if (groupone == null || grouptwo == null)
				throw new RuntimeException("JUDGE ERROR: Not enough glyphs!");
			
			int min = Integer.MAX_VALUE;
			for (Point p1 : groupone) {
				for (Point p2 : grouptwo) {
					min = Math.min(min, dist(p1.x, p1.y, p2.x, p2.y));
				}
			}
			System.out.println(min);
		}
	}

	static int dist(int x1, int y1, int x2, int y2) {
		return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
	}

	static int[] dx = {0,1,-1,0,1,-1,1,-1};
	static int[] dy = {1,0,0,-1,1,-1,-1,1};

	static void dfs(int x, int y, ArrayList<Point> group, boolean[][] visited, char[][] grid) {
		visited[x][y] = true;
		group.add(new Point(x, y));
		for (int i = 0; i < 8; i++) {
			int DX = x+dx[i];
			int DY = y+dy[i];
			if (DX >= 0 && DX < visited.length && DY >= 0 && DY < visited[0].length) {
				if (!visited[DX][DY] && grid[DX][DY] == '1') {
					dfs(DX, DY, group, visited, grid);
				}
			}
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