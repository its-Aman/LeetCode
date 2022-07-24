function lengthOfLongestSubstring(S: string): number {
  if(!S || S.length == 0)
    return 0;
  
  const N = S.length,
        map = new Map<string, number>();
  let ans = 0;
  
  for(let i = 0, j = 0; i < N; i++) {
    
    if(map.has(S.at(i))) {
      j = Math.max(j, 1 + map.get(S.at(i)))
    }

    map.set(S.at(i), i);
    ans = Math.max(ans, i - j + 1);
  }
  
  return ans;
};