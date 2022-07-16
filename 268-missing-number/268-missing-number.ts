function missingNumber(nums: number[]): number {
  let xor = 0, i = 0;
  
  for(let num of nums)
    xor ^= (num ^ i++);
  
  return xor ^ i;
}