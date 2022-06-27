// https://leetcode.com/problems/burst-balloons/discuss/1659162/JAVA-or-DP-or-Divide-and-Conquer-or-Sliding-Window-or-Detailed-Explanation-Using-Image

function maxCoins(nums: number[]): number {
  const N = nums.length,
        arr = new Array<number>(N + 2).fill(1),
        dp = Array.from(new Array<number>(N + 2), () => new Array<number>(N + 2).fill(0));
  let ans = 0;
  
  for(let i = 1; i <= N; i++)
    arr[i] = nums[i - 1];
  
  for(let window = 1; window <= N; window++) {
    for(let left = 1; left <= N - window + 1; left++) {
      const right = left + window - 1;
      
      for(let i = left; i <= right; i++) {
        dp[left][right] = Math.max(dp[left][right], (arr[left - 1] * arr[i] * arr[right + 1]) + dp[left][i - 1] + dp[i + 1][right]);
      }
    }
  }
  return dp[1][N];
};