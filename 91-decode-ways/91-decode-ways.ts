function numDecodings(s: string): number {
  if(!(s.length || +s.at(0)))
    return 0;
  
  const N = s.length,
        waysToDecode = new Array<number>(N + 1).fill(0);
  
  waysToDecode[0] = 1;
  waysToDecode[1] = !(+s.at(0)) ? 0 : 1;
  
  for(let i = 1; i < N; i++) {
    const prev = +s.at(i - 1),
          curr = +s.at(i),
          combined = prev * 10 + curr;
    
    if(!prev && !curr || (!curr && combined > 26))
      return 0;
    else if(!prev || combined > 26)
      waysToDecode[i + 1] = waysToDecode[i];
    else if(!curr)
      waysToDecode[i + 1] = waysToDecode[i - 1];
    else
      waysToDecode[i + 1] = waysToDecode[i] + waysToDecode[i - 1];
  }
    
  return waysToDecode[N];
};