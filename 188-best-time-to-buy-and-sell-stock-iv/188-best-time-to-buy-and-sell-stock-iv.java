class Solution {
    public int maxProfit(int K, int[] prices) {
        if(K * 2 >= prices.length)
            return maxProfit(prices);
        
        int[] buy = new int[K + 1],
                sell = new int[K + 1];
        
        Arrays.fill(buy, Integer.MIN_VALUE);
        
        for(int price: prices) {
            for(int i = 1; i <= K; i++) {            
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        
        return sell[K];
    }
    
    private int maxProfit(int[] prices) {
        int ans = 0;
        
        for(int i = 1; i < prices.length; i++)
            ans += Math.max(0, prices[i] - prices[i - 1]);

        return ans;
    }
}