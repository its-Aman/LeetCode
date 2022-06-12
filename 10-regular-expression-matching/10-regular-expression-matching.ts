function isMatch(s: string, p: string): boolean {
  // return isMatch_Recursion(s, p);
  return isMatch_DP(s, p);
}

function isMatch_DP(s: string, p: string): boolean {
  const dp = Array.from(new Array<boolean>(s.length + 1), () => new Array<boolean>(p.length + 1).fill(false));
  
  dp[0][0] = true;
  
  for(let i = 1; i <= p.length; i++)
    if(p.at(i - 1) == '*')
      dp[0][i] = dp[0][i - 2];
  
  for(let i = 1; i <= s.length; ++i)
    for(let j = 1; j <= p.length; ++j)
      if(p.at(j - 1) == s.at(i - 1) || p.at(j - 1) == '.')
        dp[i][j] = dp[i - 1][j - 1];
      else if(p.at(j - 1) == '*')
        if(p.at(j - 2) == s.at(i - 1) || p.at(j - 2) == '.')
          dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
        else
          dp[i][j] = dp[i][j - 2];
  
  return dp[s.length][p.length];
}

function isMatch_Recursion(s: string, p: string): boolean {
  if(!p.length)
    return s.length == 0;
  
  let first_match = s.length && [s.at(0), '.'].includes(p.at(0));
  
  if(p.length >= 2 && p.at(1) == '*')
    return (isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p)));
  else
    return first_match && isMatch(s.substring(1), p.substring(1));
  
};