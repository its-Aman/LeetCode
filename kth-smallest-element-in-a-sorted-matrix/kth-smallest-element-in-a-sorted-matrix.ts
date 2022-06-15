// https://www.youtube.com/watch?v=w36ekZYq-Ms

function kthSmallest(matrix: number[][], k: number): number {
  const N = matrix.length;
  let low = matrix[0][0],
      hi = matrix[N - 1][N - 1];
  
  while(low < hi) {
    const mid = low + ((hi - low) >>> 1);
    let j = N - 1,
        count = 0;
    for(let i = 0; i < N; i++) {
      while(j >= 0 && matrix[i][j] > mid)
        j--;
      count += j + 1;
    }
    if(count < k)
      low = mid + 1;
    else
      hi = mid;
  }
  return low;
};