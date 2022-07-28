class Solution {
	public int orangesRotting(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 2) {
					this.bfs(grid, i, j, 2);
				}
			}
		}

		int minutes = 2;

		for (int[] row : grid) {
			for (int cell : row) {
				if (cell == 1)
					return -1;
				minutes = Math.max(cell, minutes);
			}
		}

		return minutes - 2;
	}

	public void bfs(int[][] grid, int i, int j, int minutes) {

		if (
				i < 0 || i >= grid.length 
				|| j < 0 || j >= grid[0].length 
				|| grid[i][j] == 0 
				|| (grid[i][j] > 1 && grid[i][j] < minutes)
			) {
			return;
		}

		grid[i][j] = minutes;

		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		for (int[] dir : dirs) {
			int dx = i + dir[0];
			int dy = j + dir[1];

			this.bfs(grid, dx, dy, 1 + minutes);
		}
	}

}