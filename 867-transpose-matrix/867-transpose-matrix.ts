function transpose(matrix: number[][]): number[][] {
  const M = matrix.length,
        N = matrix[0].length,
        matrixT = Array.from(new Array(N), () => new Array(M).fill(0));
  
  for(let i = 0; i < M; i++){
    for(let j = 0; j < N; j++){
      matrixT[j][i] = matrix[i][j];
    }
  }
  return matrixT;
};