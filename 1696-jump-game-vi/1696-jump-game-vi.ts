function maxResult(nums: number[], K: number): number {
  const N = nums.length,
        dp = new Array<number>(N),
        deque = new Array<number>(0);
  
  dp[N - 1] = nums[N - 1];
  deque.push(N - 1);
  
  for(let i = N - 2; i >= 0; i--) {
    if(deque[0] - i > K)
      deque.shift();
    
    dp[i] = nums[i] + dp[deque[0]];
    
    while(deque.length && dp[deque[deque.length - 1]] < dp[i])
      deque.pop();
    
    deque.push(i);
  }
  
  return dp[0];
};