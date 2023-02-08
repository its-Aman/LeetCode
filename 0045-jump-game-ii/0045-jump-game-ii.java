class Solution {

    public int jump(int[] nums) {
        int N = nums.length, 
            jumps = 0,
            currEnd = 0,
            currFarthest = 0;
        
        for(int i = 0; i < N - 1; i++) {
            currFarthest = Math.max(currFarthest, i + nums[i]);
            
            if(i == currEnd) {
                jumps++;
                currEnd = currFarthest;
            }
        }
        
        return jumps;
    }
    
    public int jump2(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];

        Arrays.fill(dp, 10001);
        
        dp[N - 1] = 0;
        
        for(int i = N - 2; i >= 0; i--) {
            for(int jumpLen = 1; jumpLen <= nums[i]; jumpLen++) {
                dp[i] = Math.min(dp[i], 1 + dp[Math.min(N - 1, i + jumpLen)]);
            }
        }
        
        return dp[0];
    }
    
    private int minJump(int[] nums, int[] dp, int idx) {
        int N = nums.length;

        if(idx + 1 >= N) {
            return 0;
        }
        
        if(dp[idx] != 10001) {
            return dp[idx];
        }
        
        for(int i = 1; i <= nums[idx]; i++) {
            dp[idx] = Math.min(dp[idx], 1 + minJump(nums, dp, idx + i));
        }
        
        return dp[idx];
    }
}