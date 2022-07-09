// https://www.youtube.com/watch?v=2J4tkJ7v3r4

function minCost(houses: number[], cost: number[][], M: number, N: number, T: number): number {
  const dp = Array.from(new Array(M + 1), () => Array.from(new Array(N + 1), () => new Array(T + 1).fill(-1)));

  const ans = getMin(0, 0, 0);
  
  return ans == Infinity ? -1 : ans;
  
  function getMin(idx: number, last_color: number, nbrs: number): number {
    if(idx == M)
      return nbrs == T ? 0 : Infinity;
    
    if(nbrs > T)
      return Infinity;
    
    if(dp[idx][last_color][nbrs] != -1)
      return dp[idx][last_color][nbrs];
    
    if(houses[idx] == 0) {
      let ans = Infinity;
      
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