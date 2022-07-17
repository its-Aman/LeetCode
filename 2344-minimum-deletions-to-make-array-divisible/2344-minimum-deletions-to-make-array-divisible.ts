function minOperations(nums: number[], numsDivide: number[]): number {
  const M = numsDivide.length,
        N = nums.length,
        gcdNum = numsDivide.reduce((acc, curr) => gcd(curr, acc));
  nums.sort((a, b) => a - b);

  for(let i = 0; i < N; i++)
    if(gcdNum % nums[i] == 0)
      return i;
  
  return -1;
  
  function gcd(a: number, b: number): number {    
    while(b)
      [a, b] = [b, a % b];

    return a;
  }
}

function minOperations_old(nums: number[], numsDivide: number[]): number {
  const N = nums.length;
  
  nums.sort((a, b) => a - b);

  for(let i = 0; i < N; i++) {
    
    if(checkDeletion(nums[i]))
      return i;
    
    while(nums[i] == nums[i + 1])
      i++;
  }
  
  return -1;
  
  function checkDeletion(num: number): boolean {
    let ans = true;
    
    for(let numD of numsDivide) {
      ans &&= numD % num == 0;
      if(!ans)
        return false;
    }
    
    return true;
  }
};