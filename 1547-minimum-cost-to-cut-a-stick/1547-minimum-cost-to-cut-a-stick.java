class Solution {
    public int minCost(int n, int[] cuts) {
        int N = cuts.length;
        int[] nCuts = new int[N+2];
        int[][] dp = new int[N+2][N+2];
        
        System.arraycopy(cuts, 0, nCuts, 1, N);
        nCuts[N+1] = n;
        Arrays.sort(nCuts);
        
        for(int diff=2; diff<N+2; diff++) {
            for(int l=0; l<N+2-diff; l++) {
                int r=l+diff;
                int ans = Integer.MAX_VALUE;
                for(int m=l+1; m<r; m++) {
                    ans = Math.min(ans, dp[l][m]+dp[m][r]+nCuts[r]-nCuts[l]);
                }
                dp[l][r]=ans;
            }
        }
        
        return dp[0][N+1];
    }
}