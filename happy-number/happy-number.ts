/*

function isHappy(num: number, map = new Map<number, number>()): boolean {
  const newNum = num
  .toString()
  .split('')
  .reduce((acc, curr) => acc += (+curr) * (+curr), 0);
    
  if(newNum == 1)
    return true;
  else{
    if(map.has(newNum))
      return false;
    else {
      map.set(newNum, newNum);
      return isHappy(newNum, map);
    }
  }
}

*/

// https://leetcode.com/problems/happy-number/discuss/56917/My-solution-in-C(-O(1)-space-and-no-magic-math-property-involved-)

function isHappy(num: number): boolean {
  let slow = num,
      fast = num;
  
  do{
    slow = digitSquareSum(slow);
    fast = digitSquareSum(fast);
    fast = digitSquareSum(fast);
  }while(slow != fast);
  
  return slow == 1;
}

function digitSquareSum(n: number): number {
  let sum = 0,
      temp = 0;
  while(n > 0) {
    temp = n % 10;
    sum += temp * temp;
    n = Math.floor(n / 10);
  }
  
  return sum;
}
