function maximumUniqueSubarray(nums: number[]): number {
  let i = 0,
      j = 0,
      N = nums.length,
      ans = 0,
      sum = 0,
      set = new Set<number>();
  
  while(i < N && j < N) {
    if(!set.has(nums[j])){
      sum += nums[j];
      ans = Math.max(sum, ans);
      set.add(nums[j++]);
    } else {
      sum -= nums[i];
      set.delete(nums[i++]);
    }
  }
  
  return ans;
};