class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int N = piles.size();
        int[][] dp = new int[N+1][k+1];
        
        for(int i=1; i<=N; i++) {
            for(int coin=0; coin<=k; coin++) {
                for(int sum=0,cnt=0; cnt<=Math.min(piles.get(i-1).size(), coin); cnt++) {
                    if(cnt > 0) {
                        sum += piles.get(i-1).get(cnt-1);
                    }
    
                    dp[i][coin] = Math.max(dp[i][coin], dp[i-1][coin-cnt]+sum);
                }
            }
        }
        
        return dp[N][k];
    }
}