function wordBreak(S: string, wordDict: string[]): string[] {
  const N = S.length,
        ans = new Array<string>();
  
  rec(0, "");
  
  function rec(idx: number, curr: string): void {
    for(let i = idx; i < N; i++)
      for(let word of wordDict)
        if(i + word.length <= N && S.substring(i, i + word.length) == word)
          rec(i + word.length, curr.concat(' ', word));
    
    if(curr.replace(/ /ig, '').length == N)
      ans.push(curr.trim());
  }
  
  return ans;
};