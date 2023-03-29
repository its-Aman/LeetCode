class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        return maxSatisfaction_Greedy(satisfaction);
    }
    
    public int maxSatisfaction_Greedy(int[] satisfaction) {
        int N = satisfaction.length;        
        Arrays.sort(satisfaction);
        int ans = 0, sum = 0;
        
        for(int i = N-1; i >= 0 && sum + satisfaction[i] > 0; i--) {
            sum += satisfaction[i];
            ans += sum;
        }
        
        return ans;
    }
    
    public int maxSatisfaction_DP(int[] satisfaction) {
        int N = satisfaction.length;        
        int[] prev = new int[N+2];
        
        Arrays.sort(satisfaction);
        
        for(int i = satisfaction.length - 1; i >= 0; i--) {
            int[] dp = new int[N+2];
            for(int t = 1; t <= satisfaction.length; t++) {
                dp[t] = Math.max(satisfaction[i] * t + prev[t+1], prev[t]);
            }
            prev = dp;
        }
        
        return prev[1];
    }
}