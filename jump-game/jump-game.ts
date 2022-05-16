function canJump(nums: number[]): boolean {
  const N = nums.length;
  let goal = N - 1;
  
  for(let i = N - 2; i >= 0; i--)
    if(i + nums[i] >= goal)
      goal = i;

  return goal == 0;
};
