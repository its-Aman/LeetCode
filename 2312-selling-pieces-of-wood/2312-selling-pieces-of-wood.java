class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m+1][n+1];
        
        for(var price: prices)
            dp[price[0]][price[1]] = price[2];
        
        for(int h = 1; h <= m; ++h) {
            for(int w = 1; w <= n; ++w) {
                
                for(int a = 1; a <= w/2; ++a)
                    dp[h][w] = Math.max(dp[h][w], dp[h][a] + dp[h][w - a]);

                for(int a = 1; a <= h/2; ++a)
                    dp[h][w] = Math.max(dp[h][w], dp[a][w] + dp[h - a][w]);
                
            }
        }
        
        return dp[m][n];
    }
}