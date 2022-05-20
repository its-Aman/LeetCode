function uniquePathsWithObstacles(obstacleGrid: number[][]): number {
  const M = obstacleGrid.length,
        N = obstacleGrid[0].length;
  
  if(obstacleGrid[0][0] == 1)
    return 0;
  
  obstacleGrid[0][0] = 1;  

  for(let i = 1; i < M; i++)
    if(obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1)
      obstacleGrid[i][0] = 1;
    else
      obstacleGrid[i][0] = 0;

  for(let j = 1; j < N; j++)
    if(obstacleGrid[0][j] == 0 && obstacleGrid[0][j - 1] == 1)
      obstacleGrid[0][j] = 1;
    else
      obstacleGrid[0][j] = 0;

  for(let i = 1; i < M; i++)
    for(let j = 1; j < N; j++)
      if(obstacleGrid[i][j] == 0)
        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
      else
        obstacleGrid[i][j] = 0;
  
  return obstacleGrid[M - 1][N - 1];
}