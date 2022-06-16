// https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity

function maxProduct(nums: number[]): number {
  let max = nums[0];
  
  for(let i = 1, imax = max, imin = max; i < nums.length; i++) {
    if(nums[i] < 0){
      const temp = imax;
      imax = imin;
      imin = temp;
    }
    
    imax = Math.max(nums[i] * imax, nums[i]);
    imin = Math.min(nums[i] * imin, nums[i]);
    max = Math.max(max, imax);
  }
  
  return max;
};