// https://leetcode.com/problems/longest-increasing-subsequence/discuss/1326552/Optimization-From-Brute-Force-to-Dynamic-Programming-Explained!

class Solution {
	public int lengthOfLIS(int[] nums) {
		int N = nums.length;
		var list = new int[N];
		var idx = 0;

		for (int num : nums) {
			if (idx == 0 || list[idx - 1] < num) {
				list[idx++] = num;
				continue;
			}

			int j = this.binarySearch_LowerBound(list, idx, num);
			list[j] = num;
		}

		return idx;
	}

	private int binarySearch_LowerBound(int[] list, int hi, int num) {
		int lo = 0;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;

			if (num <= list[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		return lo;
	}
}