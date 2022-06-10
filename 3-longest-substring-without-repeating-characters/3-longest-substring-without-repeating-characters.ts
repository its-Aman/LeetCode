function lengthOfLongestSubstring(s: string): number {
  if(!s || s.length == 0)
    return 0;
  
  let i = 0,
      j = 0,
      ans = -1,
      map = new Map<string, number>();
  
  for(let i = 0, j = 0; i < s.length; i++){
    
    if(map.has(s.charAt(i)))
      j = Math.max(j, map.get(s.charAt(i)) + 1);
    
    map.set(s.charAt(i), i);
    ans = Math.max(ans, i - j + 1);
  }
  
  return ans;
};