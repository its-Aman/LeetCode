/*
function totalSteps(nums: number[]): number {
  let steps = 0,
      currMaxIndex = 0,
      currMax = nums[0];
  
  for(let i = 1; i < nums.length;){
    if(nums[i] < currMax){
      while(nums[i] < currMax){
        i++
      }
      currMax = nums[i];
      steps = Math.max(steps, i - currMaxIndex - 1);
      currMaxIndex = i;
    } else {
      i++;
    }
  }
  
  return steps;
};
*/

// https://www.youtube.com/watch?v=NQGduRE1Crk
function totalSteps(nums: number[]): number {
  const N = nums.length,
        stack = [];
  let ans = 0;
  
  stack.push([nums[N - 1], 0]);
  
  for(let i = N - 2; i >= 0; i--) {
    let count = 0;
    while(stack.length && nums[i] > stack[stack.length - 1][0]){
      count = Math.max(count + 1, stack[stack.length - 1][1])
      stack.pop();
    }
    ans = Math.max(ans, count);
    stack.push([nums[i], count]);
  }
  
  return ans;
}