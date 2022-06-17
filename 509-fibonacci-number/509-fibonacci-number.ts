function fib(n: number, map = new Map<number, number>()): number {
  if(n < 2)
    return n;
  
  if(!map.has(n))
    map.set(n, fib(n-1) + fib(n-2));
  
  return map.get(n);
};