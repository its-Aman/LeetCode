function permute(nums: number[]): number[][] {
  const N = nums.length,
        result = [];
  
  backtrack(result, [], 0);
  
  return result;
  
  function backtrack(result: number[][], curr: number[], start: number) {
    if(curr.length == N){
      result.push(curr.slice(0));
      return;
    }
    
    for(let i = 0; i < N; i++){
      if(curr.includes(nums[i]))
        continue;
      
      curr.push(nums[i]);
      backtrack(result, curr, i + 1);
      curr.pop();
    }
  }
};