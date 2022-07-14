function addBinary(a: string, b: string): string {
  if(b.length > a.length)
    return addBinary(b, a);
  
  let carry = 0,
      ans = [];

  const M = a.length,
        N = b.length;
  
  for(let i = N - 1; i >= 0; i--) {
    let x = +a.at(M - N + i),
        y = +b.at(i),
        res = x + y + carry;
    
    if(res > 1) {
      carry = 1;
      ans.push((res % 2).toString());
    } else {
      carry = 0;
      ans.push(res.toString());
    }
  }
  
  for(let i = M - N - 1; i >= 0; i--) {
    let x = +a.at(i),
        res = x + carry;

    if(res > 1) {
      carry = 1;
      ans.push((res % 2).toString());
    } else {
      carry = 0;
      ans.push(res.toString());
    }
  }
  
  if(carry)
    ans.push(carry.toString());
  
  return ans.reverse().join('');
};