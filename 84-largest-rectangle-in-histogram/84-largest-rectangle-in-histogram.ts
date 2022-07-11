function largestRectangleArea(heights: number[]): number {

  const N = heights.length,
        stack = new Array();
  let maxArea = 0;
  
  for(let i = 0; i < N; i++) {
    let start = i;
    
    while(stack.length && stack[stack.length - 1][1] > heights[i]) {
      const [idx, ht] = stack.pop();
      maxArea = Math.max(maxArea, ht * (i - idx));
      start = idx;
    }
    
    stack.push([start, heights[i]]);
  }
  
  for(let [idx, ht] of stack)
    maxArea = Math.max(maxArea, ht * (N - idx));
  
  return maxArea;
};