// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/discuss/660632/Kt-Js-Py3-Cpp-Sliding-Window-Seen-Strings/560088
/*
function hasAllCodes(s: string, k: number): boolean {
  
  for(let i = 0; i < (1 << k); i++){
    let bin = i.toString(2);
    if (bin.length < k)
      bin = '0'.repeat(k - bin.length) + bin;
    if(!s.includes(bin))
      return false;
  }
  
  return true;
};
*/
function hasAllCodes(s: string, k: number): boolean {
  const set = new Set<string>();
  
  for(let i = 1; i <= s.length; i++){
    if(i >= k)
      set.add(s.substring(i - k, i))
  }
  
  return set.size === (1 << k);
}