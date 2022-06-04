function partition(s: string): string[][] {
  const result = [];
  
  helper(s, [], result, new Map());
  
  return result;
};

function helper(s: string, step: string[], result: string[][], dp: Map<string, boolean>): void {
//   base case
  // console.log({s, step, result})
  if(!s || s.length == 0){
    result.push(step.slice(0));
    return;
  }
  
  for(let i = 1; i <= s.length; i++) {
    const temp = s.substring(0, i);
    
    if(!dp.has(temp))
      dp.set(temp, isPalindrome(temp))
    
    if(!dp.get(temp))
      continue;
    
    step.push(temp);
    helper(s.substring(i, s.length), step, result, dp);
    step.pop();
  }
}

function isPalindrome(s: string){
  // console.log({s})
  let l = 0,
      r = s.length - 1;
  
  while(l <= r){
    if(s.charAt(l) != s.charAt(r))
      return false;
    l++;
    r--;
  }
  
  return true;
}