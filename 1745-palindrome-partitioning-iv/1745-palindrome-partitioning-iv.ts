// https://leetcode.com/problems/palindrome-partitioning-iv/discuss/1042902/Here's-your-Cake
function checkPartitioning(S: string): boolean {
  const N = S.length,
        dp = Array.from(Array(N), () => Array(N).fill('_'.repeat(4)));
  
  for(let i = N - 1; i >= 0; i--){
    for(let j = i; j < N; j++){
      const len = j - i + 1;
      if(len == 1){
        dp[i][j] = true;
      } else if(len == 2){
        dp[i][j] = S.charAt(i) == S.charAt(j);
      } else {
        dp[i][j] = (S.charAt(i) == S.charAt(j)) && dp[i + 1][j - 1];        
      }
      // console.log({i, j, len}, S.charAt(i), S.charAt(j), S.substring(j, i), dp[i][j])
    }
  }
  
  // console.log(dp);
  
  for(let p = 0;  p < N; p++){
    const left = dp[0][p];
    
    if(!left)
      continue;
    
    for(let s = p + 2; s < N; s++){
      const mid = dp[p + 1][s - 1],
            right = dp[s][N - 1];
      // console.log({l: S.substring(0, p+1), m: S.substring(p+1, s), r: S.substring(s, N)}, {p, s})
      if(mid && right)
        return true;
    }
  }
  
  return false;
}

function checkPartitioning_BRUTE_FORCE(s: string): boolean {
  const N = s.length;
  
  for(let i = 2; i < N; i++){
    if(isPal(i, N - 1)) {
      for(let j = 1; j < i; j++)
        if(isPal(0, j - 1) && isPal(j, i - 1))
          return true;
    }
  } 
  
  return false;

  function isPal(l: number, r: number): boolean {
    while(l <= r)
      if(s.charAt(l++) != s.charAt(r--))
        return false;
    return true;
  }
  
};
