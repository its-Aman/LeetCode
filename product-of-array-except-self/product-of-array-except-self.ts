function productExceptSelf(nums: number[]): number[] {
  const N = nums.length,
        ans = new Array(N).fill(1);
  let right = 1;
  
  for(let i = 1; i < N; i++)
    ans[i] = ans[i - 1] * nums[i - 1];

  for(let i = N - 1; i >= 0; i--){
    ans[i] = ans[i] * right;
    right *= nums[i];
  }
  
  return ans;
};