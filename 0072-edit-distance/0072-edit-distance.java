class Solution {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int N1 = w1.length, N2 = w2.length;
        int[][] dp = new int[N1+1][N2+1];
        
        if(N1 == 0 || N2 == 0) {
            return N1 + N2;
        }
        
        for(int i = 1; i <= N1; i++) {
            dp[i][0] = i;
        }
        
        for(int j = 1; j <= N2; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i <= N1; i++) {
            for(int j = 1; j <= N2; j++) {
                if(w1[i-1] == w2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                }
            }
            
        }
        
        return dp[N1][N2];
    }
}