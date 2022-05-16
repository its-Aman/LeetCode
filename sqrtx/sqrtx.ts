// https://www.youtube.com/watch?v=OxUFaTwKp7E

function mySqrt(x: number): number {  
  let l = 1,
      r = x;
  
  if(x < 2)
    return x;
  
  while(l < r){
    const mid = l + Math.floor((r - l) / 2),
          num = Math.floor(x / mid);
    if(num == mid)
      return mid;
    else if(num < mid)
      r = mid;
    else 
      l = mid + 1;      
  }
  
  return l - 1;
};