function nextGreaterElements(nums: number[]): number[] {
  const N = nums.length,
        res = new Array(N),
        stack = [];
  let i = 2 * N - 1;
  
  while(i >= 0){
    while(stack.length != 0 && stack[stack.length - 1] <= nums[i % N])
      stack.pop();
  
    res[i % N] = stack.length > 0 ? stack[stack.length - 1] : -1;
    
    stack.push(nums[i % N]);
    i--;
  }
  return res;
};