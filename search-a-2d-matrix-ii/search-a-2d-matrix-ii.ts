function searchMatrix(matrix: number[][], target: number): boolean {
  const M = matrix.length,
        N = matrix[0].length;

  let row = 0,
      col = N - 1;
  
  while(col >= 0 && row <= M - 1){
    if(target == matrix[row][col])
      return true;
    else if(target < matrix[row][col])
      col--
    else
      row++
  }
  
  return false;
};