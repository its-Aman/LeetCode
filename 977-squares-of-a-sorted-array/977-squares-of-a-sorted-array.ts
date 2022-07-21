function sortedSquares(nums: number[]): number[] {
  return nums
    .sort((a, b) => Math.abs(a) - Math.abs(b))
    .map(num => num * num);
};