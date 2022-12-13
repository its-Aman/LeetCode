class Solution {
    public int minFallingPathSum(int[][] M) {
        return minFallingPathSum_memo(M);
    }

    public int minFallingPathSum_rec(int[][] M) {
        int ans = Integer.MAX_VALUE,
                N = M.length;
        var dp = M.clone();

        for (int r = 1; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int nbrs = Math.min(M[r - 1][Math.max(0, c - 1)], M[r - 1][Math.min(N - 1, c + 1)]);
                int min = Math.min(M[r - 1][c], nbrs);
                dp[r][c] += min;
            }
        }
        
        for(int c = 0; c < N; c++)
            ans = Math.min(ans, M[N-1][c]);

        return ans;
    }
    
    public int minFallingPathSum_memo(int[][] M) {
        int ans = Integer.MAX_VALUE,
                N = M.length;
        var dp = new int[N][N];

        for(int c = 0; c < N; c++)
            ans = Math.min(ans, dfs(0, c, M, dp));
        
        return ans;
    }

    private int dfs(int r, int c, int[][] M, int[][] dp) {
        int N = M.length;
        
        if(r == N - 1 && c >= 0 && c <= N - 1)
            return M[r][c];
        
        if(r >= N || c < 0 || c >= N)
            return Integer.MAX_VALUE;
        
        if(dp[r][c] != 0)
            return dp[r][c];
        
        int one = dfs(r + 1, c - 1, M, dp);
        int two = dfs(r + 1, c, M, dp);
        int three = dfs(r + 1, c + 1, M, dp);
        
        return dp[r][c] = M[r][c] + Math.min(one, Math.min(two, three));
    }
}