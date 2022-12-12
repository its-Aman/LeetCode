class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[50];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        
        return dp[n];
    }
    
    public int climbStairs_rec(int n) {
        int[] dp = new int[n + 2];

        return countStairs(n, dp);
    }
    
    public int countStairs(int n, int[] dp) {
        if(n < 4) return n;
        
        if(dp[n] == 0)
            dp[n] = countStairs(n - 1, dp) + countStairs(n - 2, dp);

        return dp[n];
    }
}