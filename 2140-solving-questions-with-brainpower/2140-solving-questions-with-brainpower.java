class Solution {
    public long mostPoints(int[][] questions) {
        int N = questions.length;
        long[] dp = new long[N];
        
        dp[N-1] = questions[N-1][0];
        
        for(int i=N-2; i>=0; i--) {
            dp[i] = Math.max(questions[i][0] + (i+1+questions[i][1] < N ? dp[i+1+questions[i][1]] : 0), dp[i+1]);
        }
        
        return dp[0];
    }
}