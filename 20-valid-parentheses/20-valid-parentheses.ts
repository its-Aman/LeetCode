function isValid(s: string): boolean {
  const stack = new Array();
  
  for(let c of s) {
    if(['(', '[', '{'].includes(c)) {
      stack.push(c);
    } else if(stack.length) {
      const elem = stack.pop();
      
      if(
        !((c == ')' && elem == '(') || 
        (c == ']' && elem == '[') ||
        (c == '}' && elem == '{'))
      ){
        return false;
      }
        
    } else {
      return false;
    }
  }
  
  return stack.length == 0;
};