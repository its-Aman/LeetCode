function wordBreak(S: string, wordDict: string[]): string[] {
  const N = S.length,
        ans = new Array<string>();
  
  rec(0, "");
  
  function rec(idx: number, curr: string): void {
    // console.log({idx, curr})
    for(let i = idx; i < N; i++) {
      for(let word of wordDict) {
        // console.log({word, sub:S.substring(i, i + word.length)})
        if(i + word.length <= N && S.substring(i, i + word.length) == word) {
          rec(i + word.length, curr.concat(' ', word));
        }
      }
    }
    
  if(curr.replace(/ /ig, '').length == N)
    ans.push(curr.trim());
  }
  
  return ans;
};