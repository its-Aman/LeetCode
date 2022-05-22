// Solution: Approach 5: Binary Search

function findDuplicate_BinarySearch(nums: number[]): number {
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

// Solution: Approach 6: Sum of Set Bits

function findDuplicate_SumOfSetBits(nums: number[]): number {
  const N = nums.length,
        maxBit = calcMaxBit(nums);
  let dup = 0;
  
  for(let bit = 0; bit < maxBit; bit++){
    let mask = (1 << bit),
        base_count = 0,
        num_count = 0;
    
    for(let i = 0; i < N; i++){
      if((i & mask) > 0)
        base_count++;
      
      if((nums[i] & mask) > 0)
        num_count++;
    }
    if(num_count > base_count)
      dup |= mask;
  }
  return dup;
}

function calcMaxBit(nums: number[]){ 
  let num = Math.max(...nums),
      bits = 0;
  while(num > 0){
    num /= 2;
    bits++;
  }
  return bits;
}

// Solution: Approach 7: Floyd's Tortoise and Hare (Cycle Detection)

function findDuplicate(nums: number[]): number {
  let tortoise = nums[0],
      hare = nums[0];
  
  do{
    tortoise = nums[tortoise];
    hare = nums[nums[hare]];
  } while(tortoise != hare);
  
  tortoise = nums[0];

  while(tortoise != hare){
    tortoise = nums[tortoise];
    hare = nums[hare];
  }
  return hare;
}