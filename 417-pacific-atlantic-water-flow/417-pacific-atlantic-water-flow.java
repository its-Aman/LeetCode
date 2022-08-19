class Solution {

	private int R, C;
	private int[][] dirs;
	private boolean[][] atlantic;
	private boolean[][] pacific;
	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		this.R = heights.length;
		this.C = heights[0].length;
		this.dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		this.atlantic = new boolean[R + 1][C + 1];
		this.pacific = new boolean[R + 1][C + 1];

		for (int r = 0; r < R; r++) {
			this.dfs(heights, this.atlantic, r, 0);
			this.dfs(heights, this.pacific, r, this.C - 1);
		}

		for (int c = 0; c < C; c++) {
			this.dfs(heights, this.atlantic, 0, c);
			this.dfs(heights, this.pacific, this.R - 1, c);
		}

		return this.ans;
	}

	private void dfs(int[][] heights, boolean[][] visited, int r, int c) {
		if (visited[r][c])
			return;

		visited[r][c] = true;

		if (this.atlantic[r][c] && this.pacific[r][c])
			this.ans.add(Arrays.asList(r, c));

		for (int[] dir : this.dirs) {
			int dr = r + dir[0], dc = c + dir[1];

			if ((dr >= 0 && dr < this.R) && (dc >= 0 && dc < this.C) && heights[dr][dc] >= heights[r][c]) {
				this.dfs(heights, visited, dr, dc);
			}
		}
	}
}
