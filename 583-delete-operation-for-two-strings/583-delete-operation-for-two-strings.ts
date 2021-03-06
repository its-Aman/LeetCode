function minDistance(w1: string, w2: string): number {
  return minDistance_LCS_with_1D_DP(w1, w2);
}

function minDistance_LCS_with_1D_DP(w1: string, w2: string): number {
  const len1 = w1.length,
        len2 = w2.length;
  let dp = new Array<number>(len2 + 1);

  for(let i = 0; i <= len1; i++) {
    const temp = new Array<number>(len2 + 1);
    for(let j = 0; j <= len2; j++) {
      if(!i || !j)
        temp[j] = i + j;
      else if(w1.at(i - 1) == w2.at(j - 1))
        temp[j] = dp[j - 1];
      else 
        temp[j] = 1 + Math.min(temp[j - 1], dp[j]);
    }
    dp = temp;
  }
  
  return dp[len2];
}

function minDistance_LCS_withDP(w1: string, w2: string): number {
  const len1 = w1.length,
        len2 = w2.length,
        dp = Array.from(new Array<Array<number>>(len1 + 1), () => new Array<number>(len2 + 1));

  for(let i = 0; i <= len1; i++)
    for(let j = 0; j <= len2; j++)
      if(!i || !j)
        dp[i][j] = i + j;
      else if(w1.at(i - 1) == w2.at(j - 1))
        dp[i][j] = dp[i - 1][j - 1];
      else 
        dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]);
  
  return dp[len1][len2];
}

function minDistance_LCS_with_memo(w1: string, w2: string): number {
  const len1 = w1.length,
        len2 = w2.length,
        memo = Array.from(new Array<Array<number>>(len1 + 1), () => new Array<number>(len2 + 1).fill(-1));
  
  return len1 + len2 - 2 * lcs(len1, len2);

  function lcs(i: number, j: number): number {
    if(!i || !j)
      return 0;
  
    if(~memo[i][j])
      return memo[i][j];
    
    if(w1.at(i - 1) == w2.at(j - 1))
      memo[i][j] = 1 + lcs(i - 1, j - 1);
    else
      memo[i][j] = Math.max(lcs(i - 1, j), lcs(i, j - 1));
    
    return memo[i][j];
  }
}

function minDistance2(w1: string, w2: string): number {
  const len1 = w1.length,
        len2 = w2.length,
        map = new Map<string, number>();
  
  if(w2.length > w1.length)
    return dfs(w2, w1);
  else
    return dfs(w1, w2);
  
  function dfs(w1: string, w2: string): number {
    const key = w1.concat('_', w2);
    
    if(map.has(key))
      return map.get(key);
    
    if(w1 == w2)
      return 0;
    
    if(!w1.length && w2.length)
      return w2.length;

    if(w1.length && !w2.length)
      return w1.length;
    
    if(!w1.length && !w2.length)
      return len1 + len2;
    
    map.set(
      w1.substring(1).concat('_', w2),
      dfs(w1.substring(1), w2)
    );
    
    map.set(
      w1.substring(0, w1.length - 1).concat('_', w2),
      dfs(w1.substring(0, w1.length - 1), w2)
    );
    
    map.set(
      w1.concat('_', w2.substring(1)),
      dfs(w1, w2.substring(1))
    );
    
    map.set(
      w1.concat('_', w2.substring(0, w2.length - 1)),
      dfs(w1, w2.substring(0, w2.length - 1))
    );
    
    return Math.min(
    1 + map.get(w1.substring(1).concat('_', w2)),
    1 + map.get(w1.substring(0, w1.length - 1).concat('_', w2)),
    1 + map.get(w1.concat('_', w2.substring(1))),
    1 + map.get(w1.concat('_', w2.substring(0, w2.length - 1))),
    );
  }
  
};