function checkXMatrix(grid: number[][]): boolean {
  let isX = true;
  const N = grid.length;
  
  for(let i = 0; i < N; i++) {
    if(grid[i][i] == 0 || grid[i][N - i - 1] == 0)
      isX &&= false;
    
    if(!isX)
      return isX;
  }
  
  for(let i = 0; i < N; i++) {
    
    for(let j = 0; j < N; j++) {
      
      if((i == j) || (i == N - j - 1))
        continue;
      
      if(grid[i][j] != 0)
        isX &&= false;
    }

    if(!isX)
      return isX;
  }
  
  return isX;
};