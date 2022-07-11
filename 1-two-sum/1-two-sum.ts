function twoSum(nums: number[], target: number): number[] {
  const N = nums.length,
        map = new Map<number, number>();
  
  for(let i = 0; i < N; i++)
    if(map.has(target - nums[i]))
      return [map.get(target - nums[i]), i];
    else
      map.set(nums[i], i);
};