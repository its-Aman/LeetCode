// https://www.youtube.com/watch?v=Cbbf5qe5stw

function removeInvalidParentheses(s: string): string[] {
  const ans = new Array(0),
        map = new Map<string, boolean>();

  backtrack(s, getInvalidParenthesesCount(s));
  
  if(ans.length)
    return ans;
  else
    return [""];
  
  function backtrack(curr: string, invalidCount: number): void {
    
    if(invalidCount < 0 || map.has(curr))
      return;
    
    map.set(curr, true);
    
    if(invalidCount == 0 && getInvalidParenthesesCount(curr) == 0) {
      ans.push(curr);
      return;
    }
    
    for(let i = 0; i < curr.length; i++){
      const left = curr.substring(0, i),
            right = curr.substring(i + 1);
      
      backtrack(left.concat(right), invalidCount - 1);
    }
  }

  function getInvalidParenthesesCount(s: string): number {
    let left = 0,
        right = 0;
    for(let i = 0; i < s.length; i++){
      if(s.charAt(i) == '(')
        left++;
      else if(s.charAt(i) == ')')
        if(left > 0)
          left--;
        else
          right++;
    }
    return left + right;
  }
  
  
  function getInvalidParenthesesCountStack(s: string): number {
    
    const stack = [];
    
    for(let c of s){
      if(!['(', ')'].includes(c))
        continue;
      if(c == '(')
        stack.push(c);
      else if(c == ')')
        if(!stack.length)
          stack.push(c);
        else if(stack[stack.length - 1] == ')')
          stack.push(c);
        else if(stack[stack.length - 1] == '(')
          stack.pop();
    }

    return stack.length;
  }
};