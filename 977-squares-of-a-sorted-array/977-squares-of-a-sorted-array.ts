function sortedSquares(nums: number[]): number[] {
  const N = nums.length,
        ans = new Array(N);
  let i = 0,
      j = N - 1,
      idx = N - 1;
  
  while(i <= j) {
    const ith = nums[i] * nums[i],
          jth = nums[j] * nums[j];
    
    if(ith > jth) {
      ans[idx--] = ith;
      i++;
    } else {
      ans[idx--] = jth;
      j--; 
    }
  }

  return ans;
};