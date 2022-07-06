function fib(N: number, map = new Map<number, number>()): number {
  if(N == 0)
    return 0;
  
  if(N <= 2)
    return 1;
  
  let n1 = 1,
      n2 = 1;
  
  while(N-- > 2)
    [n1, n2] = [n2, n1 + n2]; 
  
  return n2;
};