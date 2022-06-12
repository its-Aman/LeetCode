// https://www.youtube.com/watch?v=SxtxCSfSGlo

function numSubarrayProductLessThanK(nums: number[], K: number): number {

  if(K <= 1)
    return 0;
  
  const N = nums.length;
  let prod = 1,
      result = 0,
      left = 0,
      right = 0;
  
  while(right < N) {
    prod *= nums[right];
    
    while(prod >= K)
      prod /= nums[left++];
    
    result += right - left + 1;
    right++;
  }
  
  return result;
};