class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profits) {
        int MOD = 1000000007;
        int[][][] dp = new int[101][101][101];
        int N = group.length;
        
        for(int cnt=0; cnt<=n; cnt++) {
            dp[N][cnt][minProfit] = 1;
        }
        
        for(int idx=N-1; idx>=0; idx--) {
            for(int cnt=0; cnt<=n; cnt++) {
                for(int profit=0; profit<=minProfit; profit++) {
                    dp[idx][cnt][profit] = dp[idx+1][cnt][profit] % MOD;
                    if(cnt+group[idx]<=n) {
                        dp[idx][cnt][profit] = (dp[idx][cnt][profit] + dp[idx+1][cnt+group[idx]][Math.min(minProfit, profit+profits[idx])]) % MOD;
                    }
                }
            }
        }
        
        return dp[0][0][0];
    }
}