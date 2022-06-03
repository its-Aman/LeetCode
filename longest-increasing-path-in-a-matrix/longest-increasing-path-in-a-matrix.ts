function longestIncreasingPath(matrix: number[][]): number {
  const M = matrix.length,
        N = matrix[0].length,
        dp = Array.from(Array(M), () => Array(N).fill(0)),
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]];
  
  let max = 0;
  
  for(let i = 0; i < M; i++)
    for(let j = 0; j < N; j++)
      max = Math.max(max, dfs(i, j));
  
  return max;
  
  function dfs(i: number, j: number): number {
    if(dp[i][j])
      return dp[i][j];
    
    let currMax = 1;
        
    for(let [x, y] of dirs){
      const dx = i + x,
            dy = j + y;

      if(dx < 0 || dx >= M || dy < 0 || dy >= N || matrix[dx][dy] <= matrix[i][j])
        continue;
      
      currMax = Math.max(currMax, 1 + dfs(dx, dy));
    }

    dp[i][j] = Math.max(dp[i][j], currMax);
    return currMax;
  }
};