class Solution {
    public int findKthPositive(int[] nums, int k) {
        int l = 0, r = nums.length, m;
        while (l < r) {
            m = (l + r) / 2;
            if (nums[m] - 1 - m < k)
                l = m + 1;
            else
                r = m;
        }
        return l + k;
    }
}