// https://leetcode.com/problems/basic-calculator-ii/solution/1352318

function calculate(s: string): number {
  s = s.concat('+');
  let N = s.length,
      total = 0,
      prev = 0, 
      curr = 0,
      op = '+';
  
  for(let c of s){
    if(c == ' ')
      continue;
    
    if(!'+-/*'.includes(c)){
        curr = curr*10 + (+c);
        continue;
    }
    
    if(op == '+'){
      total += prev;
      prev = curr;
    } else if(op == '-'){
      total += prev;
      prev = -curr;
    } else if(op == '*'){
      prev *= curr;
    } else if(op == '/'){
      prev = Math.trunc(prev/curr);
    }

    curr = 0;
    op = c;
  }
  
  return total + prev;
};