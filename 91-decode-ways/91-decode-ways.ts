function numDecodings(s: string): number {
  const memo = new Map<string, number>();
  
  return dfs(s);
  
  function dfs(s: string): number {
    if(memo.has(s))
      return memo.get(s);
    
    if(s.length && s.at(0) == '0'){
      memo.set(s, 0);
      return 0;
    }
    
    if(!s || s.length == 1){
      memo.set(s, 1);
      return 1;      
    }
    
    const firstStr = s.substring(1);
    memo.set(firstStr, dfs(firstStr));

    if(+s.substring(0,2) <= 26) {
      const secondStr = s.substring(2);
      memo.set(secondStr, dfs(secondStr));
      return memo.get(firstStr) + memo.get(secondStr);
    } else {
      return memo.get(firstStr);
    }
  }
};