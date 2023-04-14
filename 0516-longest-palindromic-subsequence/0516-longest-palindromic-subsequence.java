class Solution {
    public int longestPalindromeSubseq(String s) {
        int N = s.length();
        int[][] dp = new int[N+1][N+1];
        
        for(int i = N-1; i >= 0; i--) {
            dp[i][i] = 1;

            for(int j = i+1; j < N; j++) {
                
                if(s.charAt(i) == s.charAt(j)) {
                   dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                   dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);                    
                }

                // System.out.printf("%d\t%d\t%d\t\n", i, j, dp[i][j]);
            }
        }
        
        return dp[0][N-1];
    }
}