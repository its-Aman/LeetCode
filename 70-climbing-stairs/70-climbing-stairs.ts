function climbStairs(N: number): number {
  if(N < 4)
    return N;
  
  const dp = new Array<number>(N + 1);

  for(let i = 0; i <= N; i++){
      
    if(i < 4) {
      dp[i] = i;
    } else {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
  }
  
  return dp[N];
};