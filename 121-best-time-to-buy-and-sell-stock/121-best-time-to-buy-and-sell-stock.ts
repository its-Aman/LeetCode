function maxProfit(prices: number[]): number {
  let ans = 0,
      minPrice = Number.MAX_SAFE_INTEGER;
  
  for(let price of prices) {
    minPrice = Math.min(minPrice, price);
    ans = Math.max(ans, price - minPrice);
  }
  
  return ans;
};