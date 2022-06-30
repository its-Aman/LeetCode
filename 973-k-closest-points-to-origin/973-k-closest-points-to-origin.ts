function kClosest(points: number[][], K: number): number[][] {
  const N = points.length;
  let lo = 0, 
      hi = N - 1;
  
  while(lo <= hi) {
    const mid = helper(lo, hi);
    if(mid == K)
      break;
    else if(mid < K)
      lo = mid + 1;
    else
      hi = mid - 1;
  }
  
  return points.splice(0, K);
  
  function helper(lo: number, hi: number): number {
    const pivot = points[lo];
    
    while(lo < hi) {
      while(lo < hi && compare(points[hi], pivot) >= 0)
        hi--;
      points[lo] = points[hi];

      while(lo < hi && compare(points[lo], pivot) <= 0)
        lo++;
      points[hi] = points[lo];      
    }
    
    points[lo] = pivot;
    return lo;
  }
  
  function compare([x1, y1]: Array<number>, [x2, y2]: Array<number>): number {
    return (x1 * x1 - x2 * x2) + (y1 * y1 - y2 * y2);
  }
};