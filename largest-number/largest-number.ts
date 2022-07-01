function largestNumber(nums: number[]): string { 
  const ans = nums
  .map(String)
  .sort((a, b) => a.concat(b) > b.concat(a) ? -1 : 1)
  .join('');
  
  return ans.at(0) == '0' ? '0' : ans;
};