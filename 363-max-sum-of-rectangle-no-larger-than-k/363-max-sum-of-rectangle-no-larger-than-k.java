class Solution {
	public int maxSumSubmatrix(int[][] M, int K) {

		int R = M.length, C = M[0].length, ans = Integer.MIN_VALUE;

        if (C > R) {
			int[][] MM = new int[C][R];

			for (int r = 0; r < R; r++)
				for (int c = 0; c < C; c++)
					MM[c][r] = M[r][c];

			return this.maxSumSubmatrix(MM, K);
		}

		for (int left = 0; left < C; left++) {
			int[] temp = new int[R];

			for (int right = left; right < C; right++) {

				for (int r = 0; r < R; r++)
					temp[r] += M[r][right];

				ans = Math.max(ans, this.maxSumSubArray(temp, K));
			}
		}

		return ans;
	}

	private int maxSumSubArray(int[] nums, int K) {
		TreeSet<Integer> bst = new TreeSet<Integer>();
		int ans = Integer.MIN_VALUE;
		bst.add(0);

		for (int i = 0, right = 0; i < nums.length; i++) {
			right += nums[i];
			Integer left = bst.ceiling(right - K);
			if (left != null)
				ans = Math.max(ans, right - left);
			bst.add(right);
		}

		return ans;
	}
}