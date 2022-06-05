function subsetXORSum(nums: number[]): number {
  const N = nums.length;
  let ans = 0;
  
  backtrack([], 0);
  
  return ans;
  
  function backtrack(curr: number[], start: number): void {
    ans += curr.reduce((acc, curr) => acc ^ curr, 0);
    
    for(let i = start; i < N; i++){
      curr.push(nums[i]);
      backtrack(curr, i + 1);
      curr.pop();
    }
  }
};