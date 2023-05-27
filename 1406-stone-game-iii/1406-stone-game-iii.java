class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int N = stoneValue.length;
        int[] dp = new int[4];

        for(int i=N-1; i>=0; i--) {
            dp[i%4] = stoneValue[i] - dp[(i+1)%4];
            
            if(i+2<=N) dp[i%4] = Math.max(dp[i%4], stoneValue[i]+stoneValue[i+1]-dp[(i+2)%4]);

            if(i+3<=N) dp[i%4] = Math.max(dp[i%4], stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-dp[(i+3)%4]);
        }

        if(dp[0] > 0) return "Alice";
        if(dp[0] < 0) return "Bob";
        
        return "Tie";
    }
}