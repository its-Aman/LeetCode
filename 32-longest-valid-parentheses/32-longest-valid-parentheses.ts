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
// Solution: Approach 2: Using Dynamic Programming

function longestValidParentheses(s: string): number {
  const N = s.length,
        dp = new Array(N).fill(0);
  let max = 0;
  
  for(let i = 1; i < N; i++){
    if(s.charAt(i) == ')'){
      if(s.charAt(i - 1) == '(') {
        dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
      } else if(i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
        dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2 >= 0) ? dp[i - dp[i - 1] - 2] : 0);
      }
      max = Math.max(max, dp[i]);
    }
  }
  return max;
}

/*
// Solution: Approach 3: Using Stack

function longestValidParentheses(s: string): number {
  const stack = [-1];
  let max = 0;
  
  for(let i = 0; i < s.length; i++) {
    if(s.charAt(i) == '('){
      stack.push(i);
    } else {
       stack.pop();
       if(stack.length)
         max = Math.max(max, i - stack[stack.length - 1]);
      else 
          stack.push(i);
    }
  }
  return max;
}

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
*/