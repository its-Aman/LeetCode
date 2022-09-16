class Solution {
    
    public int maximumScore(int[] nums, int[] ops) {
        // int[][] dp = new int[ops.length + 1][ops.length + 1];
        int[] dp = new int[ops.length + 1];
        
        for(int i = ops.length - 1; i >= 0; i--) {
            int[] prev_dp = dp.clone();
            
            for(int l = i; l >= 0; l--) {
                int left = (nums[l] * ops[i]) + prev_dp[l + 1];
                int right = (nums[(nums.length - 1) - (i - l)] * ops[i]) + prev_dp[l];
                dp[l] = Math.max(left, right);
            }
            
        }
        
        return dp[0];
    }
}