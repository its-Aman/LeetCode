function largestNumber(nums: number[]): string {
  const N = nums.length,
        l = console.log;
  
  const res = nums
    .map(String)
    .sort((a, b) => (a.concat(b) > b.concat(a)) ? -1 : 1)
    .join('');
  
  return res.at(0) == '0' ? '0' : res
};