/*
function missingNumber(nums: number[]): number {
  const N = nums.length,
        sigma = (N * (N + 1)) / 2,
        sum = nums.reduce((acc, curr) => acc + curr);
  return sigma - sum;
};
*/

function missingNumber(nums: number[]): number {
  let xor = 0, i = 0;
  
  for(let num of nums)
    xor ^= (num ^ i++);
  
  return xor ^ i;
}