// https://www.youtube.com/watch?v=3ZDZ-N0EPV0

/*
The idea is to build a 2D dp array to store the match uptill the i-th string and j-th pattern. 
*/

function isMatch(s: string, p: string): boolean {
  let i = 0,
      writeIndex = 0,
      isFirst = true,
      S = s.length,
      P = p.length,
      pattern = p.split(''),
      str = s.split('');
  
  const dp = Array.from(new Array<Array<boolean>>(S + 1), () => new Array<boolean>(P + 1).fill(false));

  // this loop will eleminate all the repeating *
  // consider this example
  // e.g a**b***c --> a*b*c

  
  while(i < P) {
    if(pattern[i] == '*'){
      if(isFirst){
        pattern[writeIndex++] = pattern[i++];
        isFirst = false;
      } else {
        i++;
      }
    } else {
      pattern[writeIndex++] = pattern[i++];
      isFirst = true;
    }
  }
        
    // if pattern starting with *, we can say that for each str of upto 1 length,
    // we have a match.
  
    if(writeIndex > 0 && pattern[0] == '*')
      dp[0][1] = true;
    
    // since the empty string matches with empty pattern, hence: 
      dp[0][0] = true;

    
    for(let i = 1; i < S + 1; i++)
      for(let j = 1; j < P + 1; j++)
        if(pattern[j - 1] == '?' || str[i - 1] == pattern[j - 1])
          dp[i][j] = dp[i - 1][j - 1];
        else if(pattern[j - 1] == '*')
          dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
  
  return dp[S][writeIndex];
}  