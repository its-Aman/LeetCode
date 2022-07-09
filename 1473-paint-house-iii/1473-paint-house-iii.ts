function minCost(houses: number[], cost: number[][], M: number, N: number, T: number): number {
  const dp = Array.from(new Array(M + 1), () => Array.from(new Array(N + 1), () => new Array(T + 1).fill(-1)));

  const ans = getMin(0, 0, 0);
  
  if(ans == Number.MAX_SAFE_INTEGER)
    return -1;
  else
    return ans;
  
  function getMin(idx: number, last_color: number, nbrs: number): number {
    if(idx == M)
      if(nbrs == T)
        return 0;
      else
        return Number.MAX_SAFE_INTEGER;
    
    if(nbrs > T)
      return Number.MAX_SAFE_INTEGER;
    
    if(dp[idx][last_color][nbrs] != -1)
      return dp[idx][last_color][nbrs];
    
    if(houses[idx] == 0) {
      let ans = Number.MAX_SAFE_INTEGER;
      
      for(let curr_color = 0; curr_color < N; curr_color++) {
        if(curr_color + 1 == last_color) {
          ans = Math.min(ans, getMin(idx + 1, last_color, nbrs) + cost[idx][curr_color]);
        } else {
          ans = Math.min(ans, getMin(idx + 1, curr_color + 1, nbrs + 1) + cost[idx][curr_color]);
        }
      }
      return dp[idx][last_color][nbrs] = ans;
    } else {
      let ans = 0;
      
      if(houses[idx] == last_color) {
        ans = getMin(idx + 1, last_color, nbrs);
      } else {
        ans = getMin(idx + 1, houses[idx], nbrs + 1);
      }
      return dp[idx][last_color][nbrs] = ans;
    }
  }
  
};