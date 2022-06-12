// https://www.youtube.com/watch?v=STrSxM_-imM

function minPathCost(grid: number[][], moveCost: number[][]): number {
  const M = grid.length,
        N = grid[0].length,
        dp = Array.from(new Array<number>(M), () => new Array<number>(N));
  
  for(let i = 0; i < N; ++i)
    dp[M - 1][i] = grid[M - 1][i];
  
  for(let i = M - 2; i >= 0; --i) {
    for(let j = 0; j < N; j++) {
      let ans = Number.MAX_SAFE_INTEGER;
      
      for(let k = 0; k < N; k++)
        ans = Math.min(ans, dp[i + 1][k] + moveCost[grid[i][j]][k]);
      
      dp[i][j] = ans + grid[i][j];
    }
  }
  
  return Math.min(...dp[0]);
}

function minPathCost_copy(grid: number[][], moveCost: number[][]): number {
  let M = grid.length,
      N = grid[0].length,
      dp = Array.from(new Array<number>(M), () => new Array<number>(N).fill(0));
  
  for(let i = 0; i < N; i++)
    dp[M - 1][i] = grid[M - 1][i];
  
  for(let i = M - 2; i >= 0; --i) {
    for(let j = 0; j < N; ++j) {
      let ans = Number.MAX_SAFE_INTEGER;
      for(let k = 0; k < N; ++k){
        // console.log({i, j, k, ans, dp: dp[i + 1][k], mc: moveCost[grid[i][j]][k]})
        ans = Math.min(ans, dp[i + 1][k] + moveCost[grid[i][j]][k]);
      }
      dp[i][j] = ans + grid[i][j];
      // console.log({dp})
    }
  }
  
  return Math.min(...dp[0]);
};