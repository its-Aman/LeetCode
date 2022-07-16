/**
 Do not return anything, modify nums in-place instead.
 */
function moveZeroes(nums: number[]): void {
  const N = nums.length;
  
  for(let i = 0, j = 0; i < N; i++) {
    if(nums[i] != 0) {
      [nums[j], nums[i]] = [nums[i], nums[j]];
      j++;
    }
  }
};