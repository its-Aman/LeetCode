function isInterleave(s1: string, s2: string, s3: string): boolean {
  return isInterleave_2n_dp(s1, s2, s3);
}

function isInterleave_1n_dp(s1: string, s2: string, s3: string): boolean {
  const L = s1.length,
        M = s2.length,
        N = s3.length;
  
  if(L + M != N)
    return false;

  const dp = new Array(M + 1).fill(false);
  
  for(let j = 0; j <= M; j++)
    dp[j] = s2.substr(0, j) == s3.substr(0, j);
  
  for(let i = 0; i <= L; i++) {
    dp[0] = s1.substr(0, i) == s3.substr(0, i);
    
    for(let j = 1; j <= M; j++)
      dp[j] = (dp[j] && s3.at(i + j - 1) == s1.at(i - 1)) || (dp[j - 1] && s3.at(i + j - 1) == s2.at(j - 1));
  }
  
  return dp[M];
}

function isInterleave_2n_dp(s1: string, s2: string, s3: string): boolean {
/*
Here is some explanation:

DP table represents if s3 is interleaving at (i+j)th position when s1 is at ith position, and s2 is at jth position. 0th position means empty string.

So if both s1 and s2 is currently empty, s3 is empty too, and it is considered interleaving. If only s1 is empty, then if previous s2 position is interleaving and current s2 position char is equal to s3 current position char, it is considered interleaving. similar idea applies to when s2 is empty. when both s1 and s2 is not empty, then if we arrive i, j from i-1, j, then if i-1,j is already interleaving and i and current s3 position equal, it s interleaving. If we arrive i,j from i, j-1, then if i, j-1 is already interleaving and j and current s3 position equal. it is interleaving.
*/
  
  const L = s1.length,
        M = s2.length,
        N = s3.length;
  
  if(L + M != N)
    return false;

  const dp = Array.from(new Array(L + 1), () => new Array(M + 1).fill(false));

  for(let i = 0; i <= L; i++) {
    for(let j = 0; j <= M; j++) {
      const curr = s3.at(i + j - 1);
      
      if(i == 0 && j == 0)
        dp[i][j] = true;
      else if(i == 0)
        dp[i][j] = dp[i][j - 1] && s2.at(j - 1) == curr;
      else if(j == 0)
        dp[i][j] = dp[i - 1][j] && s1.at(i - 1) == curr;
      else
        dp[i][j] = (dp[i - 1][j] && s1.at(i - 1) == curr) || (dp[i][j - 1] && s2.at(j - 1) == curr);
    }
  }
  
  return dp[L][M];
}

function isInterleave_sol(s1: string, s2: string, s3: string): boolean {
  if(s1.length + s2.length != s3.length)
    return false;
  
  const L = s1.length,
        M = s2.length,
        N = s3.length,
        memo = Array.from(new Array(L), () => new Array(M).fill(-1));
  
  return is_interleave(0, 0, 0);

  function is_interleave(i: number, j: number, k: number): boolean {
    if(i == L)
      return s2.substring(j) == s3.substring(k);

    if(j == M)
      return s1.substring(i) == s3.substring(k);
    
    if(memo[i][j] != -1)
      return memo[i][j] == 1;
    
    let ans = ((s3.at(k) == s1.at(i) && is_interleave(i + 1, j, k + 1)) 
        || (s3.at(k) == s2.at(j) && is_interleave(i, j + 1, k + 1)));
    
    memo[i][j] = ans ? 1: 0;
    
    return ans;
  }
}