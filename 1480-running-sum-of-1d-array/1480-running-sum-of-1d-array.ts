function runningSum(nums: number[]): number[] {
  const N = nums.length,
        ans = [nums[0]];
  
  for(let i = 1; i < N; i++){
    ans.push(ans[ans.length - 1] + nums[i]);
  }
  
  return ans;
};