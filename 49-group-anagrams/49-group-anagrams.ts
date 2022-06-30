function groupAnagrams(strs: string[]): string[][] {
  const map = new Map<string, Array<string>>();
  
  for(let str of strs) {
    const sort_str = str.split('').sort().join('');
    
    if(map.has(sort_str)) 
      map.get(sort_str).push(str);
    else
      map.set(sort_str, [str]);
  }
  
  return Array.from(map.values());
};