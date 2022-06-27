function minPartitions(N: string): number {
  let ans = 0;
  
  for(let n of N) {
    ans = Math.max(ans, +n);
    if(ans == 9)
      return ans;
  }
  
  return ans;
};