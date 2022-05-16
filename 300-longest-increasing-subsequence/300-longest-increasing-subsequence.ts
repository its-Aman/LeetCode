/*
https://www.youtube.com/watch?v=odrfUCS9sQk
*/

function lengthOfLIS(nums: number[]): number {
  let max = 0,
      N = nums.length,
      dp = new Array(N).fill(1);
  
  if(N <= 1)
    return N;
  
  for(let i = 1; i < N; i++){
    for(let j = 0; j < i; j++){
      if(nums[j] < nums[i])
        dp[i] = Math.max(dp[i], 1 + dp[j])
    }
    max = Math.max(max, dp[i]);
  }

  return max;
};