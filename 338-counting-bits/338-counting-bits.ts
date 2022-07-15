function countBits(N: number): number[] {
  const ans = new Array(N + 1).fill(0);
  
  for(let i = 0; i <= N; i++)
    ans[i] = ans[i >> 1] + (i & 1);
      
  return ans;
};