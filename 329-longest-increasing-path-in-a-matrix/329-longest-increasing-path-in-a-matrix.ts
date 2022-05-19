function longestIncreasingPath(matrix: number[][]): number {
  let M = matrix.length,
      N = matrix[0].length,
      cache = Array.from(new Array(M).fill(0), () => new Array(N).fill(0)),
      max = 1,
      dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]];
  
  for (let i = 0; i < M; i++)
      for (let j = 0; j < N; j++)
          max = Math.max(max, dfs(i, j));
  
  return max;
  
  function dfs(i: number, j: number): number {
    if(cache[i][j])
      return cache[i][j];
    
    let currMax = 1;
    
    for(let [dirX, dirY] of dirs){
      let x = dirX + i,
          y = dirY + j;
    
      if(x < 0 || x >= M || y < 0 || y >= N || matrix[x][y] <= matrix[i][j])
        continue;
      
      currMax = Math.max(currMax, dfs(x, y) + 1);
    }
    cache[i][j] = Math.max(currMax, cache[i][j]);
    return currMax;
  }
  
};
