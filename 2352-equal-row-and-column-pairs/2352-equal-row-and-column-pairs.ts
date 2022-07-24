function equalPairs(grid: number[][]): number {
  const N = grid.length;
  
  let ans = 0;

  for(let r = 0; r < N; r++) {

    for(let c = 0; c < N; c++) {

      let isSeen = true;
      
      for(let k = 0; k < N; k++) {
        if(grid[r][k] !== grid[k][c])
          isSeen = false;
        if(!isSeen)
          break;
      }
      
      ans += isSeen ? 1 : 0;
    }
  }

  return ans;
};