function search(nums: number[], target: number): number {

  let start = 0,
      lo = 0,
      hi = nums.length - 1;
  
  while(lo < hi){
    const mid = lo + Math.floor((hi - lo) / 2);
    if(nums[mid] > nums[hi])
      lo = mid + 1;
    else
      hi = mid;
  }

  start = lo;
  lo = 0;
  hi = nums.length - 1;
  
  if(target >= nums[start] && target <= nums[hi])
    lo = start;
  else
    hi = start;
  
  while(lo <= hi){
    const mid = lo + Math.floor((hi - lo) / 2);
    if(nums[mid] == target)
      return mid;
    else if(nums[mid] > target)
      hi = mid - 1;
    else
      lo = mid + 1;
  }

  return -1
};