function minMoves2(nums: number[]): number {
  nums.sort((a, b) => a - b);
  
  const pivot = nums[nums.length >>> 1];
  let ans = 0;
  
  for(let num of nums)
    ans += Math.abs(pivot - num);

  return ans;
};