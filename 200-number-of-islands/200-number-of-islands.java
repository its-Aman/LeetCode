class Solution {

	public int numIslands(char[][] grid) {
		int ans = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					ans += 1;
					this.bfs(grid, i, j);
				}
			}
		}

		return ans;
	}

	public void bfs(char[][] grid, int i, int j) {

		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1')
			return;

		grid[i][j] = '0';

		this.bfs(grid, i + 1, j);
		this.bfs(grid, i - 1, j);
		this.bfs(grid, i, j + 1);
		this.bfs(grid, i, j - 1);
	}
}