function climbStairs(N: number): number {
  if(N < 4)
    return N;
  
  const dp = new Array<number>(N + 1);
  
  dp[0] = 0;
  dp[1] = 1;
  dp[2] = 2;

  for(let i = 3; i <= N; i++)
    dp[i] = dp[i - 1] + dp[i - 2];
  
  return dp[N];
};