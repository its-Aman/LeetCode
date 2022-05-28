function missingNumber(nums: number[]): number {
  const N = nums.length,
        sigma = (N * (N + 1)) / 2,
        sum = nums.reduce((acc, curr) => acc + curr);
  return sigma - sum;
};