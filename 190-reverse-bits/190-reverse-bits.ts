function reverseBits(num: number): number {
	let ans = 0;
  
  for(let i = 31; i >= 0; i--) {
    ans <<= 1;
    ans |= (num & 1);
    num >>= 1;
  }
  
  return ans >>> 0;

};