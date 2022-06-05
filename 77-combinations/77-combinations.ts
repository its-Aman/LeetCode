function combine(N: number, K: number): number[][] {
  const result = [];
  
  backtrack(result, [], 1);

  function backtrack(result: number[][], curr: number[], i: number): void {
    
    if(curr.length == K){
      result.push(curr.slice(0));
      return;
    }
    
    for(let j = i; j <= N; j++) {
      curr.push(j);
      backtrack(result, curr, j + 1);
      curr.pop();
    }
  }
  
  return result;
};