/*
 // => Naive way
function longestValidParentheses(s: string): number {
  const N = s.length,
        map = new Map<string, boolean>();
  let max = 0;

  if(N == 0)
    return max;
  
  for(let i = 0; i < N; i++){
    for(let j = N; j >= 0; j--) {
      if(!map.has(s.substring(i, j)))
        map.set(s.substring(i, j), validParantheses(s.substring(i, j)))

      if(map.get(s.substring(i, j))){
        max = Math.max(max, j - i);
      }
    }
  }
  return max;
};

function validParantheses(s: string): boolean {
  let stack = [],
      N = s.length;
  
  for(let i = 0; i < N; i++) {
    if(s.charAt(i) == '('){
      stack.push('(');      
    } else {
      if(stack.length)
        stack.pop();
      else
        return false;
    }
  }
  return stack.length == 0;
}
*/

// Solution: Approach 4: Without extra space

function longestValidParentheses(s: string): number {
  let l = 0, 
      r = 0, 
      max = 0;
  
  for(let i = 0; i < s.length; i++){
    if(s.charAt(i) == '(')
      l++;
    else
      r++;
    
    if(l == r)
      max = Math.max(max, r + l);
    else if(r > l)
      l = r = 0;
  }

  l = r = 0;

  for(let i = s.length - 1; i >= 0; i--){
    if(s.charAt(i) == '(')
      l++;
    else
      r++;
    
    if(l == r)
      max = Math.max(max, r + l);
    else if(l > r)
      l = r = 0;
  }
  
  return max;
}