function updateMatrix(mat: number[][]): number[][] {
  return updateMatrix_dp(mat);
}

function updateMatrix_dp(mat: number[][]): number[][] {
  const R = mat.length,
        C = mat[0].length,
        ans = Array.from(new Array(R), () => new Array(C).fill(Number.MAX_SAFE_INTEGER));

  for(let r = 0; r < R; r++) {
    
    for(let c = 0; c < C; c++) {
      
      if(mat[r][c] == 0) {
        
        ans[r][c] = 0;
        
      } else {
        
        if(c > 0)
          ans[r][c] = Math.min(ans[r][c], 1 + ans[r][c - 1]);

        if(r > 0)
          ans[r][c] = Math.min(ans[r][c], 1 + ans[r - 1][c]);
        
      }
    }
  
  }
  
  for(let r = R - 1; r >= 0; r--) {
    
    for(let c = C - 1; c >= 0; c--) {
      
      if(1 + r < R)
        ans[r][c] = Math.min(ans[r][c], 1 + ans[1 + r][c]);
      
      if(1 + c < C)
        ans[r][c] = Math.min(ans[r][c], 1 + ans[r][1 + c]);
      
    }
  }
  
  
  return ans;
};

function updateMatrix_bfs(mat: number[][]): number[][] {
  const R = mat.length,
        C = mat[0].length,
        ans = Array.from(new Array(R), () => new Array(C).fill(Number.MAX_SAFE_INTEGER)),
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]];

  let Q = new Array(0),
      i = 0;

  for(let r = 0; r < R; r++)
    for(let c = 0; c < C; c++)
      if(mat[r][c] == 0) {
        ans[r][c] = 0;
        Q.push([r, c]);
      }

  
  while(i < Q.length) {
    const [r, c] = Q[i++];

    console.log({r, c, i, Q, ans})
    
    for(let [x, y] of dirs) {
      let dr = x + r,
          dc = y + c;
      
      if((dr >= 0 && dc >= 0 && dr < R && dc < C) && (ans[dr][dc] > 1 + ans[r][c])) {
        ans[dr][dc] = 1 + ans[r][c];
        Q.push([dr, dc]);
      }
    }
  }
  
  return ans;
};