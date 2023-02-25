class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = 10001, ans = 0;
        
        for(int price: prices) {
            minPrice = Math.min(minPrice, price);
            ans = Math.max(ans, price - minPrice);
        }
        
        return ans;
    }
}