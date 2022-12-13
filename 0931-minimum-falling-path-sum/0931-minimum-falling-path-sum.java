class Solution {
    public int minFallingPathSum(int[][] M) {
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
}