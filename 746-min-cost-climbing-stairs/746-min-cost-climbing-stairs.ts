function minCostClimbingStairs(cost: number[]): number {
  return minCostClimbingStairs_TD_const_space(cost);
  // return minCostClimbingStairs_TD(cost);
  // return minCostClimbingStairs_DP_Recursion(cost);
  
}

function minCostClimbingStairs_TD_const_space(cost: number[]): number {
  const N = cost.length;
  let first = cost[0],
      second = cost[1];
  
  for(let i = 2; i < N; i++)
    [first, second] = [second, cost[i] + Math.min(first, second)]
  
  return Math.min(first, second);
}

function minCostClimbingStairs_TD(cost: number[]): number {
  const N = cost.length,
        dp = new Array<number>(N).fill(-1);

  for(let i = 0; i < N; i++) {
    if(i < 2)
      dp[i] = cost[i];
    else
      dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
  }
  
  return Math.min(dp[N - 1], dp[N - 2]);
}

function minCostClimbingStairs_DP_Recursion(cost: number[]): number {
  const N = cost.length,
        dp = new Array<number>(N).fill(-1);
  
  return Math.min(fn(N - 1), fn(N - 2));
  
  function fn(idx: number): number {
    if(idx == 0 || idx == 1)
      return cost[idx];

    if(dp[idx] > 0)
      return dp[idx];
    
    return dp[idx] = cost[idx] + Math.min(fn(idx - 1), fn(idx - 2));
  }
};