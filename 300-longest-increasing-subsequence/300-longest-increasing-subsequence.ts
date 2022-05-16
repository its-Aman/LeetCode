function lengthOfLIS(nums: number[]): number {  
  let max = 0,
      N = nums.length,
      dp = new Array(N - 1).fill(1);
  
  if(N == 1)
    return 1;
  
  for(let i = 1; i < N; i++){
    let currMax = 1;
    for(let j = 0; j < i; j++){
      // console.log(nums[j], nums[i], currMax, dp[j]);
      if(nums[j] < nums[i])
        currMax = Math.max(currMax, 1 + dp[j])
    }
    dp[i] = currMax;
    max = Math.max(max, dp[i]);
  }
  
//   console.log(dp);
  
  return max;
};