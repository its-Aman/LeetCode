function minCut(s: string): number {
  const N = s.length,
        dp = new Array(N).fill(-1),
        ans = helper(0);
  
  return ans - 1;
  
  function helper(i: number): number {
    if(i == N)
      return 0;
    
    if(dp[i] != -1)
      return dp[i];
    
    let min = N;
        
    for(let j = i; j < N; j++){
      if(!isPalindrome(i, j))
        continue;
      
      min = Math.min(min, 1 + helper(j + 1));
    }
    
    return dp[i] = min;
  }
  
  function isPalindrome(l: number, r: number): boolean {    
    let ans = true;

    while(l <= r){
      if(s.charAt(l) != s.charAt(r)){
        ans = false;
        break;
      }
      l++;
      r--;
    }

    return ans;
  }
};