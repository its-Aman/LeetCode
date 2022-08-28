class Solution {

    public int[][] diagonalSort(int[][] M) {
		int R = M.length, C = M[0].length;
		int[][] ans = new int[R][C];

		for (int c = 0; c < C; c++)
			this.countSort(M, ans, 0, c);

		for (int r = 0; r < R; r++)
			this.countSort(M, ans, r, 0);

		return ans;
	}

	private void countSort(int[][] M, int[][] A, int R, int C) {
		int[] cnt = new int[101];
		int r = R, c = C;

		while (r < A.length && c < A[0].length)
			cnt[M[r++][c++]] += 1;

		r = R;
		c = C;

		for (int i = 1; i < 101; i++) {
			if (cnt[i] > 0) {
				int val = cnt[i];

				while (val-- > 0)
					A[r++][c++] = i;
			}
		}
	}

    
}