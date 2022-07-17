function numberOfPairs(nums: number[]): number[] {
  const set = new Set<number>();
  let pair = 0;
  
  for(let num of nums)
    if(set.has(num)) {
      set.delete(num);
      pair++;
    } else {
      set.add(num);
    }
     
  return [pair, set.size];
}

function numberOfPairs2(nums: number[]): number[] {
  const N = nums.length,
        map = new Map<number, number>();
  let pair = 0,
      leftover = 0;
  
  for(let i = 0; i < N; i++) {
    if(!map.has(nums[i]))
      map.set(nums[i], 1);
    else
      map.set(nums[i], 1 + map.get(nums[i]));
  }
  
  for(let [key, val] of map) {
      pair += Math.floor(val / 2);
    if(val % 2 == 1) {
      leftover +=  1;
    }
  }

  return [pair, leftover];
};