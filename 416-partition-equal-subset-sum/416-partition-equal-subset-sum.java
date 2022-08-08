class Solution {
    public boolean canPartition(int[] nums) {
		int sum = IntStream.of(nums).reduce((int left, int right) -> left + right).getAsInt();

		if (sum % 2 != 0)
			return false;

		int N = nums.length;
		int target = sum / 2;
		boolean[][] knapsack = new boolean[N + 1][target + 1];

		knapsack[0][0] = true;

		for (int i = 1; i <= N; i++) {

			for (int j = 0; j <= target; j++) {

				if (j - nums[i - 1] >= 0) {
					knapsack[i][j] = knapsack[i - 1][j] || knapsack[i - 1][j - nums[i - 1]];
				} else {
					knapsack[i][j] = knapsack[i - 1][j];
				}

			}

		}

		return knapsack[N][target];
    }
}