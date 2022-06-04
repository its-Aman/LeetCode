function subsets(nums: number[]): number[][] {
  const N = nums.length,
        result = [];
  
  backtrack(result, [], 0);
  
  return result;
  
  function backtrack(result: number[][], curr: number[], start: number){
    result.push(curr);
    
    for(let i = start; i < N; i++){
      curr.push(nums[i]);
      backtrack(result, curr.slice(0), i + 1);
      curr.pop();
    }
  }
};