function majorityElement(nums: number[]): number {
  let count = 0,
      candidate = null;
  
  for(let num of nums){
    if(count == 0)
      candidate = num;
    
    count += (candidate == num) ? 1 : -1;
  }
  return candidate;
};