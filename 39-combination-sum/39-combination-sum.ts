function combinationSum(candidates: number[], target: number): number[][] {
  const N = candidates.length,
        ans = [];
  
  for(let i = 0; i < N; i++){
    backtrack(i, candidates[i], [candidates[i]])
  }
  
  return ans;

  function backtrack(i: number, currSum: number, group: number[]): void {
    if(currSum == target){
      ans.push(group.slice(0));
      return;      
    }

    if(currSum > target)
      return;
    
    for(let j = i; j < N; j++){
      group.push(candidates[j])
      backtrack(j, currSum + candidates[j], group.slice(0));
      group.pop();
    }
  }
  
};