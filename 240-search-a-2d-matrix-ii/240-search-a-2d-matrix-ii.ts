function searchMatrix(M: number[][], T: number): boolean {
  const R = M.length,
        C = M[0].length;
  let r = R - 1,
      c = 0;
  
  while(r >= 0 && c < C) {
    if(M[r][c] < T) {
      c += 1;
    } else if(M[r][c] > T) {
      r -= 1;
    } else {
      return true;
    }
  }
  
  return false;
};