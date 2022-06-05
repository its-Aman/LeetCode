function permuteUnique(nums: number[]): number[][] {
  const N = nums.length,
        used = Array(N).fill(false),
        result = [];
  
  nums.sort((a, b) => a - b);
  
  backtrack(result, [], used);
  
  return result;
  
  function backtrack(result: number[][], curr: number[], used: boolean[]): void {
    if(curr.length == N){
      result.push(curr.slice(0));
      return;
    }
    
  
    for(let i = 0; i < N; i++){
      if(used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
        continue;
      
      used[i] = true;
      curr.push(nums[i]);
      backtrack(result, curr, used);
      used[i] = false;
      curr.pop();
    }
  }
  
};