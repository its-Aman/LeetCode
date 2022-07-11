/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

var maxResult = function(nums, K) {
  // return maxResult_bottom_up(nums, K);
  // return maxResult_top_down(nums, K);
  // return maxResult_brute_force(nums, K);
  return maxResult_optimized_DP_Q(nums, K);
}

var maxResult_optimized_DP_Q = function(nums, K) {
  const N = nums.length,
        dp = new Array(N).fill(Number.MIN_SAFE_INTEGER),
        deque = new Array();
  deque.push(0);
  
  dp[0] = nums[0];
  
  for(let i = 1; i < N; i++) {
    if(deque[0] < i - K)
      deque.shift();
    
    dp[i] = nums[i] + dp[deque[0]];
    
    while(deque.length && dp[deque[deque.length - 1]] <= dp[i])
      deque.pop();
    
    deque.push(i);
  }
  
  return dp[N - 1];
}

var maxResult_optimized_DP = function(nums, K) {
  
}

var maxResult_bottom_up = function(nums, K) {
  const N = nums.length,
        dp = new Array(N).fill(Number.MIN_SAFE_INTEGER);
  dp[0] = nums[0];
  
  for(let i = 1; i < N; i++)
    for(let j = 1; j <= K && i - j >= 0; j++)
      dp[i] = Math.max(dp[i], nums[i] + dp[i - j]);

  return dp[N - 1];
}

var maxResult_top_down = function(nums, K) {
  const N = nums.length,
        dp = new Array(N).fill(Number.MIN_SAFE_INTEGER);
  dp[N - 1] = nums[N - 1];
  
  return solve(0);
  
  function solve(idx) {
    
    if(dp[idx] != Number.MIN_SAFE_INTEGER)
      return dp[idx];
    
    for(let j = 1; j <= K; j++)
      if(idx + j < N)
      dp[idx] = Math.max(dp[idx], nums[idx] + solve(idx + j));

    return dp[idx];
  }
};

var maxResult_brute_force = function(nums, K, i = 0) {
  const N = nums.length;
  
  if(i >= N - 1)
    return nums[N - 1];
  
  let ans = Number.MIN_SAFE_INTEGER;
  
  for(let j = 1; j <= K; j++)
    ans = Math.max(ans, nums[i] + maxResult(nums, K, i + j));
  
  return ans;
};