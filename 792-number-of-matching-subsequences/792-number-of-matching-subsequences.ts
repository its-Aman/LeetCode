function numMatchingSubseq(S: string, words: string[]): number {
  const N = S.length,
        dict = Array.from(new Array<string[]>(26), () => []);
  let ans = 0;
  
  for(let word of words) {
    const idx = word.charCodeAt(0) - 'a'.charCodeAt(0);
    dict[idx].push(word);
  }
  
  for(let i = 0; i < N; i++) {
    const idx = S.charCodeAt(i) - 'a'.charCodeAt(0);
    updateDict(idx);    
  }
  
  return ans;
  
  function updateDict(idx: number): void {
    const items = dict[idx];
    
    if(!items.length)
      return;
    
    dict[idx] = new Array<string>(0);
  
    for(let item of items) {
      const idx = item.charCodeAt(1) - 'a'.charCodeAt(0);
      if(item.length == 1) {
        ans += 1;
      } else {
        dict[idx].push(item.substring(1));
      }
    }
  }
};