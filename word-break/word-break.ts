function wordBreak(S: string, wordDict: string[]): boolean {
  const N = S.length,
        dp = new Array<boolean>(N + 1).fill(false);
  
  dp[N] = true;

  for(let i = N - 1; i >= 0; i--) {
    for(let word of wordDict) {
      if(i + word.length <= N && S.substring(i, i + word.length) == word)
        dp[i] = dp[i + word.length];

      if(dp[i])
        break;
    }
  }
  
  return dp[0];
};