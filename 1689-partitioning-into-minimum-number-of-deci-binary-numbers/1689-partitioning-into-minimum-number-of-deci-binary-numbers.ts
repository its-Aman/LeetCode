function minPartitions(N: string): number {
  let ans = 0;
  
  for(let n of N) {
    ans = Math.max(ans, +n);
  }
  
  return ans;
};