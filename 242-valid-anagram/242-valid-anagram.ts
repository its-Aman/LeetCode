function isAnagram(s: string, t: string): boolean {
  const map = new Map<string, number>();
  
  for(let c of s)
    map.set(c, (map.get(c) || 0) + 1);

  for(let c of t){
    if(!map.has(c))
      return false;
    else if(map.get(c) == 1)
      map.delete(c);
    else
      map.set(c, map.get(c) - 1);
  }
  
  return map.size == 0;
};