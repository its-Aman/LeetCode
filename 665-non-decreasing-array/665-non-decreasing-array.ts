// https://leetcode.com/problems/non-decreasing-array/discuss/1190763/JS-Python-Java-C%2B%2B-or-Simple-Solution-w-Visual-Explanation
/*
2 Examples:
 0  ...  i ...
 1 1 2 4[2]5 6  - in this case we can just raise a[i] to 4;
         4
 1 1 2[4]2 3 4  - in this case lower a[i-1] is better;
       2
*/

function checkPossibility(nums: number[]): boolean {
  const N = nums.length;
  let err = 0;
  
  for(let i = 1; i < N; i++) {
    if(nums[i] < nums[i - 1]) {
      if(err++ || ((i > 1 && i < N - 1) && (nums[i - 2] > nums[i]) && (nums[i + 1] < nums[i - 1])))
        return false;
    }  
  }
  return true;
};