class Solution {
    public int maxScore(int[] nums) {
        int N = nums.length, ans = 0;
        long sum = 0;
        
        Arrays.sort(nums);

        for (int i = N - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum > 0) {
                ans++;
            } else {
                break;
            }
        }

        return ans;
    }
}