function floodFill(image: number[][], sr: number, sc: number, color: number): number[][] {
  const M = image.length,
        N = image[0].length,
        originalColor = image[sr][sc];
  
  dfs(sr, sc);

  return image;
  
  function dfs(x: number, y: number): void {
    if((x < 0 || x >= M) && (y < 0 || y >= N))
      return;
  
    image[x][y] = color;
  
    const dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]];
    
    for(let [dx, dy] of dirs) {
      if((x + dx < 0 || x + dx >= M) || (y + dy < 0 || y + dy >= N))
        continue;
      
      if(image[x + dx][y + dy] == originalColor && image[x + dx][y + dy] != color) {
        image[x + dx][y + dy] = color;
        dfs(x + dx, y + dy);
      }
    }
  }
};