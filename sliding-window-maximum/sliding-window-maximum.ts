/*
// https://leetcode.com/problems/sliding-window-maximum/discuss/65881/O(n)-solution-in-Java-with-two-simple-pass-in-the-array

function maxSlidingWindow(nums: number[], k: number): number[] {
  const N = nums.length,
        max_left = new Array(N),
        max_right = new Array(N),
        max = new Array(N - k + 1);

  max_left[0] = nums[0];
  max_right[N - 1] = nums[N - 1];
  
  for(let i = 1; i < N; i++){
    max_left[i] = i % k == 0 ? nums[i] : Math.max(max_left[i - 1], nums[i]);
    const j = N - i - 1;
    max_right[j] = j % k == 0 ? nums[j] : Math.max(max_right[j + 1], nums[j]);
  }
  
  for(let i = 0, j = 0; i < N - k + 1; i++, j++)
    max[j] = Math.max(max_right[i], max_left[i + k - 1]);
  
  return max;
};
*/

// https://leetcode.com/problems/sliding-window-maximum/discuss/871317/Clear-thinking-process-with-PICTURE-brute-force-to-mono-deque-pythonjavajavascript

function maxSlidingWindow(nums: number[], k: number): number[] {
  const N = nums.length,
        q = [],
        res = [];
  
  for(let i = 0; i < N; i++){
    while(q.length && nums[q[q.length - 1]] <= nums[i])
      q.pop();
    
    q.push(i);
    
    if(q[0] == i - k)
      q.shift();
    
    if(i >= k - 1)
      res.push(nums[q[0]]);
  }
  
  return res;
}