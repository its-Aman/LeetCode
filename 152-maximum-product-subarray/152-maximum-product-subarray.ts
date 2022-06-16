function maxProduct(nums: number[]): number {

  if(nums.length == 1)
    return nums[0];
  
  let N = nums.length,
      best_positive = nums[0],
      best_negative = nums[0],
      best = nums[0];
  
  for(let i = 1; i < N; i++) {
    const curr_best_positive = nums[i] * best_positive,
          curr_best_negative = nums[i] * best_negative;
    
    best_positive = Math.max(nums[i], curr_best_positive, curr_best_negative);
    best_negative = Math.min(nums[i], curr_best_positive, curr_best_negative);
    best = Math.max(best, best_positive);
  }

  return best;
};