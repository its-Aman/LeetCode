// https://www.youtube.com/watch?v=aZuQXkO0-XA
function numSquares(n: number): number {
  const dp = new Array(n + 1).fill(0);
  
  for(let i = 1; i <= n; i++) {
    let min = Number.MAX_SAFE_INTEGER;

    for(let j = 1; j * j <= i; j++)
      min = Math.min(min, 1 + dp[i-j*j]);
    
    dp[i] = min;
  }
  
  return dp[n];
};