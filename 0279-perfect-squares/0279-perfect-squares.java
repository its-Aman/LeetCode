// https://www.youtube.com/watch?v=aZuQXkO0-XA

class Solution {
    public int numSquares(int n) {
        int ans = 0;
        int[] dp = new int[n + 1];
        
        for(int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            
            for(int j = 1; j * j <= i; j++)
                dp[i] = Math.min(dp[i], 1 + dp[i - (j * j)]);
        }
        
        return dp[n];
    }
}