function subarraySum(nums: number[], K: number): number {
  const N = nums.length,
        dp = new Array(N + 1).fill(0);
  let ans = 0;
  
  for(let i = 0; i < N; i++)
    dp[i + 1] = dp[i] + nums[i];

  for(let i = 1; i <= N; i++)
    for(let j = i - 1; j >= 0; j--) {
      const diff = dp[i] - dp[j];
      if(diff == K)
        ans += 1;
      
      // if(diff > K)
      //   break;
    }
      
  return ans;
};