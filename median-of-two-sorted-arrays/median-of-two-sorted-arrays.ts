// https://www.youtube.com/watch?v=LPFhl65R7ww

function findMedianSortedArrays(n1: number[], n2: number[]): number {
  const M = n1.length,
        N = n2.length;

  if(M > N)
    return findMedianSortedArrays(n2, n1);
  
  let low = 0,
      hi = M;
  
  while(low <= hi) {
    const partitionX = low + ((hi - low) >>> 1),
          partitionY = ((M + N + 1) >>> 1) - partitionX;

    const maxLeftX = partitionX == 0 ? Number.MIN_SAFE_INTEGER : n1[partitionX - 1],
          minRightX = partitionX == M ? Number.MAX_SAFE_INTEGER : n1[partitionX];
    
    const maxLeftY = partitionY == 0 ? Number.MIN_SAFE_INTEGER : n2[partitionY - 1],
          minRightY = partitionY == N ? Number.MAX_SAFE_INTEGER : n2[partitionY];

    if(maxLeftX <= minRightY && maxLeftY <= minRightX)
      if((M + N) % 2 == 0)
        return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
      else
        return Math.max(maxLeftX, maxLeftY);
    else if(maxLeftX > minRightY)
      hi = partitionX - 1;
    else
      low = partitionX + 1;
  }
};