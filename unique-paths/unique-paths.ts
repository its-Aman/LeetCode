function uniquePaths(m: number, n: number): number {
  return dp(m - 1, n - 1);
};

function dp(m: number, n: number, memo = new Map<string, number>()): number {  
  if(m == 0 && n == 0) {
    return 1;    
  } else if(m < 0 || n < 0) {
    return 0;
  } else {
    if(!memo.has(`${m - 1}-${n}`))
      memo.set(`${m - 1}-${n}`, dp(m - 1, n, memo))

    if(!memo.has(`${m}-${n - 1}`))
      memo.set(`${m}-${n - 1}`, dp(m, n - 1, memo))

    return memo.get(`${m - 1}-${n}`) + memo.get(`${m}-${n - 1}`);
   }
  
};