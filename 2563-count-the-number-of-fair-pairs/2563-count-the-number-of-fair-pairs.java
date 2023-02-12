class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countLess(nums, upper) - countLess(nums, lower - 1);
    }

    private long countLess(int[] nums, int val) {
        long ans = 0;
        int N = nums.length;

        for (int i = 0, j = N - 1; i < j; i++) {            
            while (i < j && nums[i] + nums[j] > val) {
                j--;
            }
            ans += j - i;
        }

        return ans;
    }
}