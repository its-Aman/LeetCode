function climbStairs(n: number, memo = new Map<number, number>()): number {
  if(n <= 3)
    return n;
  
  if(!memo.has(n))
    memo.set(n, climbStairs(n-1, memo) + climbStairs(n-2, memo));
  
  return memo.get(n);
};