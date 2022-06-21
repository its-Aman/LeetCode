function maxProfit(prices: number[]): number {
  const N = prices.length;
  let max = 0,
      min = prices[0];
  
  for(let i = 0; i < N; i++) {
    min = Math.min(min, prices[i]);
    max = Math.max(prices[i] - min, max);
  }
  
  return max;
};