function percentageLetter(s: string, letter: string): number {
  const map = new Map<string, number>(),
    N = s.length;
  
  for(let char of s){
    if(!map.has(char))
      map.set(char, 1);
    else
      map.set(char, map.get(char) + 1)
  };

  if(!map.has(letter))
    return 0;
  return Math.floor(map.get(letter)/N*100);
};