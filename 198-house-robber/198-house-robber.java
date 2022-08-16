class Solution {
    public int rob(int[] nums) {
        int N = nums.length;        
        int[] dp = new int[N + 1];
        
        dp[1] = nums[0];
        
        for(int i = 1; i < N; i++) {
            dp[i + 1] = Math.max(dp[i], nums[i] + dp[i - 1]);
        }
        
        return dp[N];
    }
}