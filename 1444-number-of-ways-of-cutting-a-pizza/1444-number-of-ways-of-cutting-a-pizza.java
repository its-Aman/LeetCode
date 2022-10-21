class Solution {
    final int MOD = (int) 1e9+7;
    int R, C, K;
    int[][] sum;
    Integer[][][] dp;
    
    public int ways(String[] pizza, int k) {
        R = pizza.length;
        C = pizza[0].length();
        K = k;
        
        sum = new int[R+1][C+1];
        
        for(int r = R - 1; r >= 0; r--)
            for(int c = C - 1; c >= 0; c--)
                sum[r][c] = sum[r+1][c] + sum[r][c+1] - sum[r+1][c+1] + (pizza[r].charAt(c) == 'A' ? 1 : 0);
        
        dp = new Integer[R][C][k+1];

        return dfs(0, 0, 1);
    }
    
    private int dfs(int r, int c, int k) {
        if(dp[r][c][k] != null)
            return dp[r][c][k];

        if(k == K)
            return dp[r][c][k] = (sum[r][c] > 0 ? 1 : 0);
        
        int ans = 0;
        
        for(int i = r; i < R-1; i++)
            if(sum[r][c] - sum[i+1][c] > 0)
                ans = (ans + dfs(i+1, c, k+1)) % MOD;

        for(int j = c; j < C-1; j++)
            if(sum[r][c] - sum[r][j+1] > 0)
                ans = (ans + dfs(r, j+1, k+1)) % MOD;

        return dp[r][c][k] = ans;
    }
}