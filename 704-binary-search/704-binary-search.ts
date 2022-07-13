function search(nums: number[], target: number): number {
  const N = nums.length;
  
  if(N == 1)
    return nums[N - 1] == target ? N - 1 : -1;
  
  let low = 0,
      hi = N - 1;
  
  while(low <= hi) {
    const mid = low + Math.floor((hi - low) / 2);
    
    if(nums[mid] == target)
      return mid;
    else if(nums[mid] > target)
      hi = mid - 1;
    else
      low = mid + 1;
  }
  
  return -1;
};