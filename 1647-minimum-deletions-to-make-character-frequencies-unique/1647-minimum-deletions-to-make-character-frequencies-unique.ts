function minDeletions(S: string): number {
  let dp = new Array(26).fill(0),
      fset = new Set<number>(),
      ans = 0;
  
  for(let c of S)
    dp[c.charCodeAt(0) - 97] += 1;
  
  dp = dp.filter(f => f).sort((a, b) => b - a);
  
  // console.log(dp)
  
  for(let i = 0; i < dp.length; i++) {
    while(dp[i] > 0 && fset.has(dp[i])) {
      dp[i] -= 1;
      ans++;
    }
    
    fset.add(dp[i]);
    
    // console.log(fset);
  }
  
  
  return ans;
};