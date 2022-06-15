
function kthSmallest(matrix: number[][], k: number): number {
  const N = matrix.length;
  let low = matrix[0][0],
      hi = matrix[N - 1][N - 1];
  
  while(low < hi) {
    const mid = low + ((hi - low) >>> 1);
    let count = 0;
    for(let i = 0; i < N; i++)
      count += upper_bound(i, mid);

    if(count < k)
      low = mid + 1;
    else
      hi = mid;
  }
  
  return low;

  function upper_bound(i: number, target: number): number {
    for(let j = 0; j < N; j++) {
      if(matrix[i][j] > target)
        return j;
    }
    
    return N;
  }
};