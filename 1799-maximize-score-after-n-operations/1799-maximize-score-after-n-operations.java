class Solution {
    public int maxScore(int[] nums) {
        int N = nums.length;
        int[] dp = new int[1<<N];
        
        Arrays.fill(dp, -1);
        
        return backtrack(nums, 0, 0, dp);
    }
    
    private int backtrack(int[] nums, int mask, int k, int[] dp) {
        if(2*k == nums.length) return 0;
        
        if(dp[mask] != -1) return dp[mask];
        
        int max = 0;
        
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if((((mask>>i)|(mask>>j))&1)==1)  continue;
                
                int newMask = mask | (1<<i) | (1<<j);
                int curr = (k+1)*gcd(nums[i], nums[j]);
                int remaining = backtrack(nums, newMask, k+1, dp);
                max = Math.max(max, remaining+curr);
            }
        }
        
        return dp[mask] = max;
    }
    
    private int gcd(int x, int y) {
        return (x == 0) ? y : gcd(y%x, x);
    }
}