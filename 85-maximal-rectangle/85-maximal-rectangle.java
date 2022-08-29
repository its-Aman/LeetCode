class Solution {
	public int maximalRectangle(char[][] M) {
		int R = M.length, C = M[0].length, ans = Integer.MIN_VALUE;
		int[] temp = new int[C];

		for (int r = 0; r < R; r++) {

			for (int c = 0; c < C; c++)
				if (M[r][c] == '0')
					temp[c] = 0;
				else
					temp[c] += M[r][c] - '0';

			ans = Math.max(ans, this.findMaxArea(temp));
		}

		return ans;
	}

	private int findMaxArea(int[] nums) {
		int N = nums.length, ans = Integer.MIN_VALUE;
		Stack<int[]> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			int start = i;

			while (!stack.isEmpty() && stack.peek()[0] > nums[i]) {
				var curr = stack.pop();
				ans = Math.max(ans, curr[0] * (i - curr[1]));
				start = curr[1];
			}

			stack.push(new int[] { nums[i], start });
		}

		while (!stack.isEmpty()) {
			var curr = stack.pop();
			ans = Math.max(ans, curr[0] * (N - curr[1]));
		}

		return ans;
	}
}