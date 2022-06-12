function countSubarrays(nums: number[], K: number): number {
  const N = nums.length;
  
  let prod = 1,
      sum = 0,
      result = 0,
      left = 0,
      right = 0;
  
  while(right < N) {
    sum += nums[right];
    prod = sum * (right - left + 1);
    
    while(prod >= K){
      sum -= nums[left++];
      prod = sum * (right - left + 1);
    }
    result += right - left + 1;
    right++;
  }
  
  return result;
};