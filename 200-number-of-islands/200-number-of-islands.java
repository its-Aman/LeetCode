class Solution {
	class UF {
		public int count = 0;
		public int[] id = null;

		public UF(int m, int n, char[][] grid) {

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == '1')
						count++;
				}
			}

			id = new int[m * n];

			for (int i = 0; i < m * n; i++)
				id[i] = i;
		}

		public int find(int p) {

			while (p != id[p]) {
				id[p] = id[id[p]];
				p = id[p];
			}

			return p;
		}

		public boolean isConnected(int p, int q) {
			int pp = find(p);
			int qq = find(q);

			return pp == qq;
		}

		public void union(int p, int q) {
			int pp = find(p);
			int qq = find(q);

			if (pp == qq)
				return;

			id[pp] = qq;

			count--;
		}
	}

	public int numIslands(char[][] grid) {
		if (grid.length == 0 || grid[0].length == 0)
			return 0;

		int m = grid.length, n = grid[0].length;

		UF uf = new UF(m, n, grid);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (grid[i][j] == '0')
					continue;

				int p = i * n + j, q;

				if (i > 0 && grid[i - 1][j] == '1') {
					q = p - n;
					uf.union(p, q);
				}

				if (i < m - 1 && grid[i + 1][j] == '1') {
					q = p + n;
					uf.union(p, q);
				}
				if (j > 0 && grid[i][j - 1] == '1') {
					q = p - 1;
					uf.union(p, q);
				}
				if (j < n - 1 && grid[i][j + 1] == '1') {
					q = p + 1;
					uf.union(p, q);
				}
			}
		}
		return uf.count;
	}
}