/*
Was trying to implement the Kadane's algorithm, but failed as it doesn't support the overall picture. 
It works for local maxima and doesn't look for the complete scenario.

function maxArea(height: number[]): number {
  let max = -1,
      prevI = 0,
      prevH = height[prevI];
  
  for(let i = 1; i < height.length; i++){
    let area = Math.min(height[i], prevH) * (i - prevI);
    console.log({area, max, i, prevI, hi: height[i], prevH})
    
    if(area > max)
      max = area;
    
    if(height[i] > prevH){
      prevI = i;
      prevH = height[i];
    }
  }
  return max;
};
*/

function maxArea(height: number[]): number {
  let l = 0,
      r = height.length - 1,
      area = 0;
  
  while(l < r){
    area = Math.max(area, Math.min(height[l], height[r]) * (r - l));
    if(height[l] < height[r])
      l++;
    else
      r--;
  }
  
  return area;
}