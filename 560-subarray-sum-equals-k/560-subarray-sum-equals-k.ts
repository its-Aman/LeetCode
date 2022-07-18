function subarraySum(nums: number[], K: number): number {
  const N = nums.length,
        map = new Map<number, number>();
  let ans = 0,
      prefix = 0;
  
  map.set(0, 1);
  
  for(let i = 0; i < N; i++) {
    prefix += nums[i];
    ans += map.get(prefix - K) || 0;
    map.set(prefix, 1 + (map.get(prefix) || 0));    
  }

  return ans;
};