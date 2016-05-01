import java.util.*;

class zamboni_cormac {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int z = in.nextInt();

		while (z-->0) {
			int row = in.nextInt();
			int col = in.nextInt();

			int x = in.nextInt();
			int y = in.nextInt();

			int total = row * col;
			int stepped = 1;

			boolean[][] visited = new boolean[row][col];
			visited[x][y] = true;

			int[] dx = {-1, 0, 1, 0};
			int[] dy = {0, 1, 0, -1};

			int dir = 0;
			int t = 1;
			int count = 0;

			while (stepped < total) {
				boolean ret = true;
				for (int i = 0; i < t; i++) {
					x = (x + dx[dir]);
					y = (y + dy[dir]);
					if (x < 0) x = row-1;
					if (x >= row) x = 0;
					if (y < 0) y = col-1;
					if (y >= col) y = 0;
					
					if (!visited[x][y]) {
						visited[x][y] = true;
						stepped++;
					}
				}

				t++;
				dir = (dir + 1) % 4;
			}

			System.out.println(t-1);
		}
	}
}