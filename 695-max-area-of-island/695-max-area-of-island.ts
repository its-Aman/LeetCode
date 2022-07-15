function maxAreaOfIsland(grid: number[][]): number {
  let maxArea = 0;
  const M = grid.length,
        N = grid[0].length,
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]];
  
  for(let i = 0; i < M; i++)
    for(let j = 0; j < N; j++)
      if(grid[i][j]) {
        grid[i][j] = 0;
        const currMax = dfs(i, j);
        maxArea = Math.max(maxArea, currMax);
      }
  
  return maxArea;
  
  function dfs(i: number, j: number): number {
    let currMax = 1;
    
    for(let [x, y] of dirs) {
      const dx = i + x,
            dy = j + y;
      
      if(dx >= 0 && dx < M && dy >= 0 && dy < N && grid[dx][dy]) {
        grid[dx][dy] = 0;
        currMax += dfs(dx, dy);
      }
    }  
    
    return currMax;
  }
};