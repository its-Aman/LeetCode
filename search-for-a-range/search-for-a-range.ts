function searchRange(nums: number[], target: number): number[] {
  const NOT_FOUND_RESPONSE = [-1, -1];
  
  if(nums.length === 0)
    return NOT_FOUND_RESPONSE;
  
  const foundAt = findIndexOfTarget(nums, target, 0, nums.length - 1);
  
  if(foundAt == -1)
    return NOT_FOUND_RESPONSE;
  
  // console.log({foundAt});
  
  let i = foundAt,
      j = foundAt;
  
  while(nums[i] == target && i >= 0)
    --i;
  
  while(nums[j] == target && j <= nums.length - 1)
    ++j;
  
  return [++i, --j];

};

function findIndexOfTarget(arr: number[], target: number, lo: number, hi: number): number {
  if(lo == hi && arr[lo] == target)
    return lo;
  else if(lo == hi && arr[lo] != target)
    return -1
  
  const mid = lo + Math.floor((hi - lo) / 2);

  if(arr[mid] == target)
    return mid;  
  else if(arr[mid] > target)
    return findIndexOfTarget(arr, target, lo, mid);
  else 
    return findIndexOfTarget(arr, target, mid + 1, hi);

}