// https://www.geeksforgeeks.org/largest-rectangle-under-histogram/

function largestRectangleArea(heights: number[]): number {
  const N = heights.length,
        stack = [];
  let maxArea = 0,
      i = 0;
    
  while(i < N){    
    if(stack.length == 0 || (heights[stack[stack.length - 1]]) <= heights[i]){
      stack.push(i);
      i++;
    } else {
      const top = stack.pop(),
            area = heights[top] * (stack.length > 0 ? (i - stack[stack.length - 1] - 1) : i);
      maxArea = Math.max(maxArea, area);
    }
  }
  
  while(stack.length > 0){
    const top = stack.pop(),
          area = heights[top] * (stack.length > 0 ? (i - stack[stack.length - 1] - 1) : i);
    maxArea = Math.max(maxArea, area);
  }
  
  return maxArea;
};