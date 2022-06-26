function findGCD(nums: number[]): number {
  let [mx, mn] = [Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER];
  
  for(let num of nums) {
    mx = Math.max(mx, num);
    mn = Math.min(mn, num);
  }
  
  return gcd(mx, mn);
};

function gcd(a: number, b: number): number {
  if(b == 0)
    return a;
  else
    return gcd(b, a % b);
}