// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75927/Share-my-thinking-process
function maxProfit(prices: number[]): number {
  let sell = 0,
      prev_sell = 0,
      buy = -prices[0],
      prev_buy = buy;
  
  for(let price of prices) {
    prev_buy = buy;
    // - price means we're buying the stock
    buy = Math.max(prev_sell - price, prev_buy);
    
    prev_sell = sell;
    // + price means we're selling the stock
    sell = Math.max(prev_buy + price, prev_sell);
  }
  return sell;
};