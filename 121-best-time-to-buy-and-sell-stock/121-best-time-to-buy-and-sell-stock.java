class Solution {
    public int maxProfit(int[] prices) {
        int min = 100001, N = prices.length, ans = 0;
        
        for(int i = 0; i < N; i++) {
            min = Math.min(min, prices[i]);
            ans = Math.max(ans, prices[i] - min);
        }
        
        return ans;
    }
}