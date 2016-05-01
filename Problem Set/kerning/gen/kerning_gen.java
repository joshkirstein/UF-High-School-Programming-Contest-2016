import java.util.*;
//joshua kirstein, random generator for kerning
public class kerning_gen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = 20;
		gen_util.emit_ln(cases);
		for (int z = 0; z < cases; z++) {
			int N = 5+gen_util.rnd.nextInt(5);
			int M = 5+gen_util.rnd.nextInt(5);
			gen_util.emit_ln(N, M);
			char[][] grid = new char[N][M];

			//first fill with 0s
			for (char[] row : grid)
				Arrays.fill(row, '0');

			// generate two shapes! TODO
			int startX = gen_util.rnd.nextInt(N);
			int startY = gen_util.rnd.nextInt(M);
			int stepsLeft = 1+gen_util.rnd.nextInt(N*M/2);
			dfs(startX, startY, 'X', stepsLeft, grid);
			int nextX = startX;
			int nextY = startY;
			while (!valid(nextX, nextY, grid, 'Y')) {
				nextX = gen_util.rnd.nextInt(N);
				nextY = gen_util.rnd.nextInt(M);
			}
			stepsLeft = 1+gen_util.rnd.nextInt(N*M/2);
			dfs(nextX, nextY, 'Y', stepsLeft, grid);

			// make all non-zero chars 1
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (grid[i][j] != '0') grid[i][j] = '1';
				}
			}

			//print
			for (char[] row : grid)
				gen_util.emit_ln(String.valueOf(row));
		}
	}
	static int[] dx = {0,1,-1,0,1,-1,1,-1};
	static int[] dy = {1,0,0,-1,1,-1,-1,1};
	static void dfs(int x, int y, char ch, int stepsLeft, char[][] grid) {
		grid[x][y] = ch;
		//if (stepsLeft == 0) return;
		ArrayList<Integer> evalOrder = new ArrayList<Integer>();
		for (int i = 0; i < 8; i++) evalOrder.add(i);
		Collections.shuffle(evalOrder);
		for (int j = 0; j < 8; j++) {
			int i = evalOrder.get(j);
			int DX = x + dx[i];
			int DY = y + dy[i];
			if (DX >= 0 && DX < grid.length && DY >= 0 && DY < grid[0].length) {
				if (grid[DX][DY] == '0' && valid(DX, DY, grid, ch)) {
					int steps = gen_util.rnd.nextInt(stepsLeft);
					if (j == 7) steps = stepsLeft;
					stepsLeft -= steps;
					if (steps == 0) continue;
					dfs(DX, DY, ch, steps, grid);
				}
			}
		}
	}
	//make sure not adjacent to any of the opposite ch
	static boolean valid(int x, int y, char[][] grid, char ch) {
		if (grid[x][y] != ch && grid[x][y] != '0') return false;
		for (int i = 0; i < 8; i++) {
			int DX = x + dx[i];
			int DY = y + dy[i];
			if (DX >= 0 && DX < grid.length && DY >= 0 && DY < grid[0].length) {
				if (grid[DX][DY] != ch && grid[DX][DY] != '0') return false;
			}
		}
		return true;
	}
}
class gen_util {
	static Random rnd = new Random();
	static void emit_ln(Object... arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) System.out.print(arr[i]);
			else {
				System.out.print(" ");
				System.out.print(arr[i]);
			}
		}
		System.out.println();
	}
}