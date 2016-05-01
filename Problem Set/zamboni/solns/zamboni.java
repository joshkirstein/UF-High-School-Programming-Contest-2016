import java.util.*;
//soln by joshua kirstein
class zamboni {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();
		while (cases-->0) {
			int rows = sc.nextInt();
			int cols = sc.nextInt();

			int startX = sc.nextInt();
			int startY = sc.nextInt();
			if (rows < 1 || cols < 1 || rows > 100 || cols > 100) throw new RuntimeException("JUDGE ERROR");
			if (startX >= rows || startX < 0 || startY >= cols || startY < 0) throw new RuntimeException("JUDGE ERROR");

			boolean[][] visited = new boolean[rows][cols];
			visited[startX][startY] = true;

			int curX = startX;
			int curY = startY;
			int dir = 0;

			int[] dx = {-1,0,1,0};
			int[] dy = {0,1,0,-1};
			int steps = 0;

			int moveAmt = 1;
			while (true) {
				boolean done = true;
				for (boolean[] row : visited)
					for (boolean entry : row)
						if (!entry) done = false;
				if (done) break;

				for (int i = 0; i < moveAmt; i++) {
					curX += dx[dir];
					curY += dy[dir];
					if (curX < 0) curX = rows-1;
					if (curY < 0) curY = cols-1;
					if (curX >= rows) curX = 0;
					if (curY >= cols) curY = 0;
					visited[curX][curY] = true;
				}

				moveAmt++;
				steps++;
				dir++;
				dir %= 4;
			}
			System.out.println(steps);
		}
	}
}