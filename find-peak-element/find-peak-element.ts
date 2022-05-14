function findPeakElement(nums: number[]): number {

  if(nums.length == 1)
    return 0;
  
  let lo = 0,
      hi = nums.length - 1;
  
  while(lo < hi){
    const mid = lo + Math.floor((hi - lo) / 2);
    if(nums[mid] > nums[mid + 1])
      hi = mid;
    else
      lo = mid + 1;
  }
  
  return lo;
};