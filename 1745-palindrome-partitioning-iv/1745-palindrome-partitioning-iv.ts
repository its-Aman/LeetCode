function checkPartitioning(s: string): boolean {
  const N = s.length;
  
  for(let i = 2; i < N; i++){
    if(isPal(i, N - 1)) {
      for(let j = 1; j < i; j++)
        if(isPal(0, j - 1) && isPal(j, i - 1))
          return true;
    }
  } 
  
  return false;

  function isPal(l: number, r: number): boolean {
    while(l <= r)
      if(s.charAt(l++) != s.charAt(r--))
        return false;
    return true;
  }
  
};
