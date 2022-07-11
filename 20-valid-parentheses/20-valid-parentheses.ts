function isValid(s: string): boolean {
  const stack = new Array();
  
  for(let c of s) {
    if(['(', '[', '{'].includes(c)) {
      stack.push(c);
    } else if(stack.length && (
          (c == ')' && stack[stack.length - 1] == '(') || 
          (c == ']' && stack[stack.length - 1] == '[') ||
          (c == '}' && stack[stack.length - 1] == '{')
        )) {
        stack.pop();
    } else {
      return false;
    }
  }
  
  return stack.length == 0;
};