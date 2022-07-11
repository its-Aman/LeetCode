function largestRectangleArea(H: number[]): number {
  const N = H.length,
        stack = new Array();
  let area = 0;
  
  for(let [i, h] of H.entries()) {
    let start = i;
    
    while(stack.length && stack[stack.length - 1][1] > h) {
      const [idx, ht] = stack.pop();
      area = Math.max(area, ht * (i - idx));
      start = idx;
    }
    
    stack.push([start, h]);
  }
  
  for(let [i, h] of stack)
    area = Math.max(area, h * (N - i));
  
  return area;
};