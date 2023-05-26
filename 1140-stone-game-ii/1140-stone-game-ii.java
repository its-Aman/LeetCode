class Solution {
    public int stoneGameII(int[] piles) {
        int N = piles.length;
        int[][][] dp = new int[2][N+1][N+1];
        
        for(int p=0; p<2; p++) {
            for(int i=0; i<=N; i++) {
                for(int m=0; m<=N; m++) {
                    dp[p][i][m] = -1;
                }
            }
        }
        return dfs(piles, dp, 0, 0, 1);
    }
    
    private int dfs(int[] piles, int[][][] dp, int p, int i, int m) {
        if(i == piles.length) return 0;
        
        if(dp[p][i][m] != -1) return dp[p][i][m];
        
        int res = p == 1 ? 1000000 : -1, s=0;
        
        for(int x=1; x<=Math.min(2*m, piles.length-i); x++) {
            s += piles[i+x-1];
            
            if(p==0) res = Math.max(res, s+dfs(piles, dp, 1, i+x, Math.max(m,x)));
            if(p==1) res = Math.min(res, dfs(piles, dp, 0, i+x, Math.max(m,x)));
        }
        
        return dp[p][i][m]=res;
    }
}