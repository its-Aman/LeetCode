function successfulPairs(spells: number[], potions: number[], success: number): number[] {
  let ans = [],
      N = spells.length,
      M = potions.length;
  
  potions.sort((a, b) => a - b);
  
  for(let i = 0; i < N; i++) {
    
    let start = 0,
        end = M;
    while(start < end) {
      const mid = start + ((end - start) >>> 1);
      if(spells[i] * potions[mid] >= success)
        end = mid;
      else
        start = mid + 1;
    }
    
    ans.push(M - start);
  }
  
  return ans;
};