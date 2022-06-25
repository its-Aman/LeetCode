function checkPossibility(nums: number[]): boolean {
  const N = nums.length;
  let isChanged = false;
  
  for(let i = 0; i < N - 1; i++) {
    if(nums[i] <= nums[i + 1])
      continue;
    if(isChanged)
      return false;
    
    isChanged = true;
    
    if(i == 0 || nums[i + 1] >= nums[i - 1])
      nums[i] = nums[i + 1];
    else
      nums[i + 1] = nums[i];
  }
  
  return true;
};