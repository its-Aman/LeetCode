function canConstruct(ransomNote: string, magazine: string): boolean {
  const N = magazine.length,
        M = ransomNote.length,
        dict = new Array<number>(26).fill(0);
  
  for(let i = 0; i < N; i++) {
    let idx = magazine.charCodeAt(i) - 97;
    dict[idx] += 1;
  }

  for(let i = 0; i < M; i++) {
    let idx = ransomNote.charCodeAt(i) - 97;
    dict[idx] -= 1;
    
    if(dict[idx] < 0)
      return false;
  }
  
  return true;
};