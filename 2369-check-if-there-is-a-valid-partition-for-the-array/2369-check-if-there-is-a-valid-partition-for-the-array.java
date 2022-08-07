class Solution {
    public boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[] {true, false, nums[0] == nums[1], false};
        
        for(int i = 2; i < nums.length; i++) {
            boolean two = nums[i] == nums[i - 1];
            boolean three = (two && nums[i] == nums[i - 2]) || (nums[i] - 1 == nums[i - 1] && nums[i - 1] - 1 == nums[i - 2]);
            
            dp[(i + 1) % 4] = dp[(i - 1) % 4] && two || dp[(i - 2) % 4] && three;
        }
        
        return dp[nums.length % 4];
    }
}