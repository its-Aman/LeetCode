/*
function myPow(x: number, n: number): number {
  let ans = 1;
  let isNeg = n < 0;
  n = Math.abs(n);
  
  while(n){
    ans *= x;
    n--;    
  }
  
  if(isNeg)
    ans = 1/ans;
  
  return ans;
};
*/

// https://leetcode.com/problems/powx-n/discuss/1226372/TypeScript-recursion

function myPow(x: number, n: number): number {
  if(n == 0)
    return 1;
  
  if(n < 0)
    return myPow(1/x, -n);
  
  const xPow2 = myPow(x, Math.trunc(n / 2));
  
  if(n % 2 == 0)
    return xPow2 * xPow2;
  
  return x * xPow2 * xPow2;
};