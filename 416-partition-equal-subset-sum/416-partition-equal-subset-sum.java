class Solution {
    public boolean canPartition(int[] nums) {
		int sum = IntStream.of(nums).reduce((int left, int right) -> left + right).getAsInt();

		if (sum % 2 != 0)
			return false;

		int N = nums.length;
		int target = sum / 2;

		boolean[] knapsack = new boolean[target + 1];

		knapsack[0] = true;

		for (int i = 1; i <= N; i++) {

			for (int j = target; j >= 0; j--) {

				if (j - nums[i - 1] >= 0) {
					knapsack[j] = knapsack[j] || knapsack[j - nums[i - 1]];
				}

			}

		}

		return knapsack[target];
    }
}