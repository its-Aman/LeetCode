function sortedSquares(nums: number[]): number[] {
  const N = nums.length,
        ans = new Array(N);
  let i = 0,
      j = N - 1,
      idx = N - 1;
  
  while(i <= j) {
    const ith = Math.abs(nums[i]),
          jth = Math.abs(nums[j]);
    
    if(ith > jth) {
      ans[idx--] = ith * ith;
      i++;
    } else {
      ans[idx--] = jth * jth;
      j--; 
    }
  }

  return ans;
};