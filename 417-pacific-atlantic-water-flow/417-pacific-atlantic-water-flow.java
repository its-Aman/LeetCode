class Solution {


	private int R, C;
	private int[] dirs;
	private boolean[][] atlantic;
	private boolean[][] pacific;
	List<List<Integer>> ans = new ArrayList<>();
	Queue<Pair<Integer, Integer>> q = new LinkedList<>();

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		this.R = heights.length;
		this.C = heights[0].length;
		this.dirs = new int[] { -1, 0, 1, 0, -1 };
		this.atlantic = new boolean[R + 1][C + 1];
		this.pacific = new boolean[R + 1][C + 1];

		for (int r = 0; r < R; r++) {
//			this.dfs(heights, this.atlantic, r, 0);
//			this.dfs(heights, this.pacific, r, this.C - 1);
			
			this.bfs(heights, this.atlantic, r, 0);
			this.bfs(heights, this.pacific, r, this.C - 1);
		}

		for (int c = 0; c < C; c++) {
//			this.dfs(heights, this.atlantic, 0, c);
//			this.dfs(heights, this.pacific, this.R - 1, c);
			
			this.bfs(heights, this.atlantic, 0, c);
			this.bfs(heights, this.pacific, this.R - 1, c);
		}

		return this.ans;
	}

	private void bfs(int[][] heights, boolean[][] visited, int r, int c) {
		this.q.offer(new Pair<Integer, Integer>(r, c));

		while (!this.q.isEmpty()) {
			Pair<Integer, Integer> curr = this.q.poll();
			r = curr.getKey();
			c = curr.getValue();

			if (visited[r][c])
				continue;

			visited[r][c] = true;

			if (this.atlantic[r][c] && this.pacific[r][c])
				this.ans.add(Arrays.asList(r, c));

			for (int dir = 0; dir < 4; dir++) {
				int dr = r + this.dirs[dir], dc = c + this.dirs[dir + 1];

				if ((dr >= 0 && dr < this.R) && (dc >= 0 && dc < this.C) && heights[dr][dc] >= heights[r][c])
					this.q.offer(new Pair<Integer, Integer>(dr, dc));
			}

		}
	}

	private void dfs(int[][] heights, boolean[][] visited, int r, int c) {
		if (visited[r][c])
			return;

		visited[r][c] = true;

		if (this.atlantic[r][c] && this.pacific[r][c])
			this.ans.add(Arrays.asList(r, c));

		for (int dir = 0; dir < 4; dir++) {
			int dr = r + this.dirs[dir], dc = c + this.dirs[dir + 1];

			if ((dr >= 0 && dr < this.R) && (dc >= 0 && dc < this.C) && heights[dr][dc] >= heights[r][c]) {
				this.dfs(heights, visited, dr, dc);
			}
		}
	}
}
