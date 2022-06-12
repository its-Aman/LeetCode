function countSubarrays(nums: number[], K: number): number {
  const N = nums.length;
  
  let sum = 0,
      result = 0,
      left = 0,
      right = 0;
  
  while(right < N) {
    sum += nums[right];
    
    while((sum * (right - left + 1)) >= K)
      sum -= nums[left++];

    result += right - left + 1;
    right++;
  }
  
  return result;
};