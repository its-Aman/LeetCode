function numSubmatrixSumTarget(matrix: number[][], T: number): number {
  const R = matrix.length,
        C = matrix[0].length,
        prefix = Array.from(new Array(R), () => new Array(C)),
        counter = new Map<number, number>();
  
  let ans = 0,
      sum = 0;

  for(let r = 0; r < R; r++) {
    for(let c = 0; c < C; c++) {

      // prefix sum row wise
      if(c == 0) {
        prefix[r][c] = matrix[r][c];
      } else {
        prefix[r][c] = prefix[r][c - 1] + matrix[r][c];
      }

    }
  }

  for(let start = 0; start < C; start++) {
    for(let end = start; end < C; end++) {
      sum = 0;
      counter.clear();
      counter.set(0, 1);

      for(let r = 0; r < R; r++) {
        sum += prefix[r][end] - (start > 0 ? prefix[r][start - 1] : 0);
        ans += counter.get(sum - T) || 0;
        counter.set(sum, 1 + (counter.get(sum) || 0));
      }
    }
  }
  
  return ans;
};