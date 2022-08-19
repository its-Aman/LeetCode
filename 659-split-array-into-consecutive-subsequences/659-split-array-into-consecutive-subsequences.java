class Solution {
    
	public boolean isPossible(int[] nums) {
		int[] left = new int[2000 + 3];
		int[] end = new int[2000 + 3];

		for (int num : nums)
			left[1000 + 1 + num] += 1;

		for (int num : nums) {
			num += 1000 + 1;

			if (left[num] <= 0)
				continue;

			left[num] -= 1;

			if (end[num - 1] > 0) {

				end[num - 1] -= 1;
				end[num] += 1;

			} else if (left[num + 1] > 0 && left[num + 2] > 0) {

				left[num + 1] -= 1;
				left[num + 2] -= 1;
				end[num + 2] += 1;

			} else {

				return false;

			}
		}

		return true;
	}
}