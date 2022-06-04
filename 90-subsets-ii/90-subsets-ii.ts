function subsetsWithDup(nums: number[]): number[][] {
  const N = nums.length,
        result = [];
  
  nums.sort((a, b) => a - b);
  
  backtrack(result, [], 0);
  
  return result;
  
  function backtrack(result: number[][], curr: number[], start: number){
    result.push(curr);
    
    for(let i = start; i < N; i++){
      if(i > start && nums[i] == nums[i - 1])
        continue;
      
      curr.push(nums[i]);
      backtrack(result, curr.slice(0), i + 1);
      curr.pop();
    }
  }
};