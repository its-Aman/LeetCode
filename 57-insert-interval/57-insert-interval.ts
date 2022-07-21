function insert(intervals: number[][], newInterval: number[]): number[][] {
  const N = intervals.length;
  
  if(N == 0)
    return [newInterval];
  
  let l = 0,
      r = N;
  
  // lower bound
  while(l < r) {
    const m = l + Math.floor((r - l) / 2);
    
    if(newInterval[0] <= intervals[m][0])
      r = m;
    else
      l = m + 1;
  }

  if(l < N && intervals[l][0] < newInterval[0])
    l++;
  
  intervals.splice(l, 0, newInterval);
  
  return mergeIntervals(intervals, Math.max(0, l - 1));
};

function mergeIntervals(intervals: number[][], start: number): number[][] {
  const N = intervals.length,
        ans = intervals.slice(0, start);
  
  for(let i = start; i < N; i++) {
    let curr = intervals[i];
    
    while((i + 1 < N) && intervals[i + 1][0] >= curr[0] && intervals[i + 1][0] <= curr[1]) {
      curr = [Math.min(intervals[i + 1][0], curr[0]), Math.max(intervals[i + 1][1], curr[1])];
      i++;
    }
    ans.push(curr.slice(0));
  }

  return ans;
}