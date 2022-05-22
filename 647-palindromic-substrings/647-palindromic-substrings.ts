// https://www.youtube.com/watch?v=XmSOWnL6T_I

function countSubstrings_DP_Method(s: string): number {
  let N = s.length,
      dp = Array.from(new Array(N), () => new Array(N).fill(false)),
      count = 0;
  
  for(let gap = 0; gap < N; gap++){
    for(let i = 0, j = gap; j < N; i++, j++){
      if(gap == 0){
        dp[i][j] = true;        
      } else if(gap == 1){
        dp[i][j] = s.charAt(i) == s.charAt(j);
      } else {
        dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
      }

      if(dp[i][j])
        count++;
    }
  }
  return count;
};

// https://www.youtube.com/watch?v=4RACzI5-du8

function countSubstrings(s: string): number {
  let res = 0;
  
  for(let i = 0; i < s.length; i++)
    res += (countPalindrome(s, i, i) + countPalindrome(s, i, i + 1));

  return res;
}

function countPalindrome(s: string, l: number, r: number): number{
  let count = 0;
  
  while((l >= 0 && r < s.length) && s.charAt(l) == s.charAt(r)){
    count++;
    l--;
    r++;
  }
  return count;
}