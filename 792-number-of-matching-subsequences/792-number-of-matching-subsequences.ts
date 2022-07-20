function numMatchingSubseq(S: string, words: string[]): number {
  const idxs = Array.from(new Array<string[]>(26), () => []);
  let ans = 0;
  
  for(let i = 0; i < S.length; i++)
    idxs[S.charCodeAt(i) - 'a'.charCodeAt(0)].push(i);
  
  for(let word of words) {
    let found = true;
    
    for(let i = 0, prev = -1; found && i < word.length; i++) {
      const curr = idxs[word.charCodeAt(i) - 'a'.charCodeAt(0)];
      const idx = upper_bound(curr, prev);
      if(idx == curr.length)
        found = false;
      else
        prev = curr[idx];
    }
    
    ans += found ? 1 : 0;
  }
  
  return ans;
  
  function upper_bound(arr: number[], index: number): number {
    let l = -1,
        r = arr.length;
    
    while(1 + l < r) {
      let m = (l + r) >>> 1;
      if(arr[m] <= index)
        l = m;
      else
        r = m; 
    }
    
    return 1 + l;
  }
}

function numMatchingSubseq_array_dict(S: string, words: string[]): number {
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