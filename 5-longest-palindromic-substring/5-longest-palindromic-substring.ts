function longestPalindrome(s: string): string {
  let max = '';
  const N = s.length,
        dp = Array.from(new Array<Array<boolean>>(N), () => new Array<boolean>(N).fill(false))

  for(let g = 0; g < N; g++) {
    
    for(let i = 0, j = g; j < N; i++, j++) {
      
      if(g == 0)
        dp[i][j] = true;
      else if(g == 1)
        dp[i][j] = s.at(i) == s.at(j);
      else
        dp[i][j] = (s.at(i) == s.at(j)) && dp[i + 1][j - 1];
      
      if(dp[i][j] && (j - i + 1) > max.length)
        max = s.substring(i, j + 1);
    }
  }
  
  return max;
};