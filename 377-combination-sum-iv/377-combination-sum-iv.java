class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        
        int ans = combinationSum4(nums, target, dp);
        return ans;
    }
    
    private int combinationSum4(int[] nums, int target, int[] dp) {
        if(target == 0) {
            return 1;
        }
        
        if(dp[target] != -1) {
            return dp[target];
        }
        
        dp[target] = 0;
        
        for(int num: nums) {
            if(num <= target) {
                dp[target] += combinationSum4(nums, target - num, dp);
            }
        }
        
        return dp[target];
    }
}