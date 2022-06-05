function partition(s: string): string[][] {
  const N = s.length,
        ans = [];
  
  backtrack(ans, [], 0);
  
  return ans;

  function backtrack(result: string[][], curr: string[], start: number): void {
    
    if(start == N){
      result.push(curr.slice(0));
      return;
    }
    
    for(let i = start; i < N; i++){
      if(isPali(start, i)){
        curr.push(s.substring(start, i + 1));
        backtrack(result, curr, i + 1);
        curr.pop();
      }
    }
  }
  
  function isPali(l: number, r: number): boolean {
    while(l <= r)
      if(s.charAt(l++) != s.charAt(r--))
        return false;
    return true;
  }
  
};