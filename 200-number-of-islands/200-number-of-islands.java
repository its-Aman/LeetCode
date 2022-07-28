class Solution {
	int ans = 0;

	public int numIslands(char[][] grid) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					this.ans += 1;
					this.bfs(grid, i, j);
				}
			}
		}

		return this.ans;
	}

	public void bfs(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
			return;

		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		grid[i][j] = '0';

		for (int k = 0; k < dirs.length; k++) {
			int dx = i + dirs[k][0];
			int dy = j + dirs[k][1];

			if (dx < 0 || dx >= grid.length || dy < 0 || dy >= grid[0].length)
				continue;

			if (grid[dx][dy] == '1')
				this.bfs(grid, dx, dy);
		}
	}
}