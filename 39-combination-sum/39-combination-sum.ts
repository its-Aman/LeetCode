function combinationSum(candidates: number[], T: number): number[][] {
  const N = candidates.length,
        ans = new Array(0);
  
  candidates.sort((a, b) => a - b);
  
  for(let i = 0; i < N; i++)
    if(candidates[i] <= T)
      backtrack(candidates[i], [candidates[i]], i);
  
  return ans;
  
  function backtrack(sum: number, currItems: number[], idx: number): void {
    
    if((sum > T) || (idx >= N))
      return;
    
    if(sum == T) {
      ans.push(currItems)
    }
  
    for(let i = idx; i < N; i++) {
      if(sum + candidates[i] > T)
        break;
      
      currItems.push(candidates[i]);
      backtrack(sum + candidates[i], currItems.slice(), i);
      currItems.pop();
    }
  }
};