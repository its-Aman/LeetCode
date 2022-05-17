function evalRPN(tokens: string[]): number {
  const ops = ['+', '-', '*', '/'],
        ans: number[] = [];
  
  for(let token of tokens) {
    if(ops.includes(token)) {
      let [a, b] = [ans.pop(), ans.pop()];
      const result = perform(b, a, token);
      ans.push(result);
      // console.log({a, b, token, ans})
    } else {
      ans.push(+token);
    }    
  }  
    
  return ans.pop();
};

function perform(a: number, b: number, op: string): number {
  let result: number;
  
  switch(op){
    case '+': result = a + b; break;
    case '-': result = a - b; break;
    case '*': result = a * b; break;
    case '/': result = Math.trunc(a / b); break;
  }
  
  return result;
}