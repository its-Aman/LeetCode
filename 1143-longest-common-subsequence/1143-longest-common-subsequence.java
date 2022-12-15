class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length(),
            N = text2.length();        
        int[][] dp = new int[M + 1][N + 1];
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(text1.charAt(i) == text2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                else
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);                    
            }
        }
        
        return dp[M][N];
    }
}