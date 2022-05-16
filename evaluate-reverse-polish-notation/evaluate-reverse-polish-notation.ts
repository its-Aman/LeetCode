function evalRPN(tokens: string[]): number {
  const ops = ['+', '-', '*', '/'];
  
  while(tokens.length > 1){
    for(let [i, token] of tokens.entries()) {
      if(ops.includes(token)){
        let [a, b, op] = tokens.splice(i - 2, 3),
            ans = perform(+a, +b, op);
        
        tokens.splice(i - 2, 0, ans);
        // console.log({op, a, b, ans, tokens})
        break;
      }    
    }  
  }
    
  return +tokens[0];
};

function perform(a: number, b: number, op: string): string {
  let ans: number;
  
  switch(op){
    case '+': ans = a + b; break;
    case '-': ans = a - b; break;
    case '*': ans = a * b; break;
    case '/': ans = a / b > 0 ? Math.floor(a / b) : Math.ceil(a / b); break;
  }
  
  return ans.toString();
}