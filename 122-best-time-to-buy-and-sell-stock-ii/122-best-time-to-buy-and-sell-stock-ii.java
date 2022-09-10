class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int currMin = 100001;
        
        for(int price: prices) {
            if(price < currMin){
                currMin = price;
            }
            
            if(price > currMin) {
                profit += price - currMin;
                currMin = price;
            }

        }
        
        return profit;
    }
}