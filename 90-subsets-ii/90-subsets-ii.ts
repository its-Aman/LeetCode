function subsetsWithDup(nums: number[]): number[][] {
  const N = nums.length,
        result = [];
  nums.sort((a, b) => a - b);
  
  backtrack(result, [], 0);
  
  return result;
  
  function backtrack(result: number[][], curr: number[], i: number){
    result.push(curr.slice(0));
 
    const set = new Set<number>();
    
    for(let j = i; j < N; j++){
      if(set.has(nums[j]))
        continue;
      
      set.add(nums[j]);

      curr.push(nums[j]);
      backtrack(result, curr, j + 1);
      curr.pop();
    }
  }
  
};