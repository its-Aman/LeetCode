// https://www.youtube.com/watch?v=w36ekZYq-Ms

function kthSmallest(matrix: number[][], k: number): number {
  const N = matrix.length;
  let low = matrix[0][0],
      hi = matrix[N - 1][N - 1];
  
  while(low < hi) {
    const mid = low + ((hi - low) >>> 1);
     let count = 0;
    
    for(let i = 0; i < N; i++) 
      count += bisect_right(i, mid);
    
    if(count < k)
      low = mid + 1;
    else
      hi = mid;
  }
  return low;

  function bisect_right(i: number, target: number): number {
    let low = 0,
        hi = N;
    
    while(low < hi) {
      const mid = low + ((hi - low) >>> 1);
      if(matrix[i][mid] <= target)
        low = mid + 1;
      else
        hi = mid;
    }
    
    return low;
  }
};
