function combinationSum2(candidates: number[], target: number): number[][] {
  const result = [],
        N = candidates.length;
  
  candidates.sort((a, b) => a - b);

  backtrack(0, 0, []);

  return result;
  
  function backtrack(start: number, currSum: number, curr: number[]){
    if(currSum == target){
      result.push(curr.slice(0));
      return;
    }
    
    if(currSum > target)
      return;
    
    for(let j = start; j < N; j++){
      if(currSum + candidates[j] > target)
        break;
      
      if((j > start) && (candidates[j] == candidates[j - 1]))
        continue;
      
      curr.push(candidates[j]);
      backtrack(j + 1, currSum + candidates[j], curr);
      curr.pop();
    }
  }
};