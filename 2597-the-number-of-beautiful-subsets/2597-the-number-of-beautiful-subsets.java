// https://leetcode.com/problems/the-number-of-beautiful-subsets/discuss/3314006/Smart-Arrangement-vs.-Bitmask-DFS

class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        return beautifulSubsets(nums, k, 0, 0);
    }

    private int beautifulSubsets(int[] nums, int k, int i, int mask) {
        if (i == nums.length) {
            return mask > 0 ? 1 : 0;
        }

        boolean isBeautiful = true;

        for (int j = 0; j < i && isBeautiful; ++j) {
            isBeautiful = (((1 << j) & mask) == 0) || Math.abs(nums[j] - nums[i]) != k;
        }

        int take = beautifulSubsets(nums, k, i + 1, mask);
        int notTake = 0;

        if (isBeautiful) {
            notTake = beautifulSubsets(nums, k, i + 1, mask + (1 << i));
        }

        return take + notTake;
    }
}