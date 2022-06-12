function matchReplacement(s: string, sub: string, mappings: string[][]): boolean {
   const set = new Set<string>();
  
   for (let [_old, _new] of mappings)
      set.add(_old + _new);
  
   for (let i = 0; i < s.length; i++)
      if (checkMatch(i))
         return true;
  
   return false;
  
   function checkMatch(start: number) {
      for (let i = 0; i < sub.length; i++) 
         if (sub[i] === s[start] || set.has(sub[i] + s[start])) 
            start++;
         else 
            return false;

     return true;
   }
}

function matchReplacement_backtrack(s: string, sub: string, mappings: string[][]): boolean {

  return backtrack(sub, mappings, 0);
  
  function backtrack(curr: string, mappings: string[][], index: number): boolean {
    console.log(curr, index)
    
    if(s.includes(curr))
      return true;
    
    if(!mappings.length || index == mappings.length - 1)
      return false;
    
    let ans = false;
    
    for(let i = 0; i < mappings.length; i++){
      let [_old, _new] = mappings[i];
      // let [[_old, _new]] = mappings.splice(i, 1);
      if(!curr.includes(_old))
        continue;
      
      let newCurr = curr.replace(_old, _new);

      if(!newCurr.includes(_old))
        mappings.splice(i, 1);
      
      ans = ans || backtrack(newCurr, mappings, i + 1);
      
      if(!newCurr.includes(_old))
        mappings.splice(i, 0, [_old, _new]);     

      newCurr = curr.replace(_new, _old);
    }
    
    return ans;
  }
  
};