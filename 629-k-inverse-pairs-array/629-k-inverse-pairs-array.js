/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var kInversePairs = function(N, K) {
  const MOD = 1000000007,
        dp = Array.from(new Array(2), () => new Array(K + 1).fill(0));
  
  dp[0][0] = 1;
  
  for(let i = 1; i <= N; i++) {
    dp[i % 2][0] = 1;
    
    for(let j = 1; j <= K; j++){
      dp[i % 2][j] = (dp[(i - 1) % 2][j] + dp[i % 2][j - 1]) % MOD;
      
      if(j >= i)
        dp[i % 2][j] = (MOD + dp[i % 2][j] - dp[(i - 1) % 2][j - i]) % MOD;
    }

  }
  
  return dp[N % 2][K] % MOD;
};