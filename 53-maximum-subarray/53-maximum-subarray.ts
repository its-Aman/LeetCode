function maxSubArray(nums: number[]): number {
  const N = nums.length;
  let curr = Number.MIN_SAFE_INTEGER,
      ans = Number.MIN_SAFE_INTEGER;
  
  for(let i = 0; i < N; i++) {
    if(curr + nums[i] > nums[i])
      curr += nums[i];
    
    if(nums[i] > curr)
      curr = nums[i];
    
    ans = Math.max(ans, curr);
  }
  
  return Math.max(ans, curr);
};