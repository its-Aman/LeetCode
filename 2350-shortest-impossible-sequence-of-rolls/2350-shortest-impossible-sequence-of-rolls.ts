function shortestSequence(rolls: number[], K: number): number {
  const set = new Set<number>();
  let ans = 0;
  
  for(let roll of rolls) {
    set.add(roll);
    
    if(set.size == K) {
      ans += 1;
      set.clear();
    }
  }
  
  return 1 + ans; 
};