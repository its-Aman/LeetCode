function findDuplicate(nums: number[]): number {
  const N = nums.length
  let l = 0,
      h = N - 1,
      dup = -1;
  
  while(l <= h){
    const mid = l + Math.floor((h - l) / 2);
    let count = 0;
    
    for(let num of nums)
      if(num <= mid)
        count++;
    
    if(count > mid){
      dup = mid;
      h = mid - 1;
    } else {
      l = mid + 1;
    }
  }
  return dup
};