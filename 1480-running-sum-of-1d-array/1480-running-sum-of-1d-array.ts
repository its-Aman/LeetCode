function runningSum(nums: number[]): number[] {
  const N = nums.length;
  
  for(let i = 1; i < N; i++){
    nums[i] += nums[i - 1]
  }
  
  return nums;
};