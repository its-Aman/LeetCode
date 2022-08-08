class Solution {
    public boolean canPartition(int[] nums) {
		int sum = IntStream.of(nums).reduce((int left, int right) -> left + right).getAsInt();

		if (sum % 2 != 0)
			return false;

		int N = nums.length;
		int target = sum / 2;

		boolean[] prev = new boolean[target + 1];
		boolean[] curr = new boolean[target + 1];

		prev[0] = true;

		for (int i = 1; i <= N; i++) {

			for (int j = 0; j <= target; j++) {

				if (j - nums[i - 1] >= 0) {
					curr[j] = prev[j] || prev[j - nums[i - 1]];
				} else {
					curr[j] = prev[j];
				}

			}

			prev = curr.clone();
		}

		return curr[target];
    }
}