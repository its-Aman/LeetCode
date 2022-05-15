function removeAnagrams(words: string[]): string[] {
  const ans = [words[0]],
        N = words.length;

  let curr = sortString(words[0]);
  
  for(let i = 1; i < N; i++) {
    let iCurr = sortString(words[i]);
    if(curr == iCurr)
      continue;
    
    ans.push(words[i]);
    curr = iCurr;
  }
  
  return ans;
};

function sortString(s: string): string {
  return s.split('').sort().join('');
}