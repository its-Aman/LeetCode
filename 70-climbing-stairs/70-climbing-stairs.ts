function climbStairs(N: number): number {
  // return climbStairs_bottom_up(N);
  return climbStairs_top_down(N);
}

function climbStairs_top_down(N: number, memo = new Map<number, number>()): number {
  if(N < 4)
    return N;
  
  if(!memo.has(N))
    memo.set(N, climbStairs_top_down(N - 1, memo) + climbStairs_top_down(N - 2, memo));

  return memo.get(N);
}

function climbStairs_bottom_up(N: number): number {
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