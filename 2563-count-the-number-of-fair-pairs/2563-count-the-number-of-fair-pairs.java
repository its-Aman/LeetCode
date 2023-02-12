class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;

        for (int i = 0, n = nums.length, lo = n - 1, hi = n - 1; i < n; ++i) {
        
            while (0 <= hi && nums[i] + nums[hi] > upper) --hi;
            while (0 <= lo && nums[i] + nums[lo] >= lower) --lo;
            
            ans += hi - lo;

            if (lo < i && i <= hi) {
                --ans;
            }
        }

        return ans / 2;
    }
}