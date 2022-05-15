/*
https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/discuss/2039717/Check-Each-Bit

function largestCombination(candidates: number[]): number {
  let res = 0,
      max_e = Math.max(...candidates);
  
  for(let j = 1; j <= max_e; j <<= 1){
    let cnt = 0;
    
    for(let candidate of candidates)
      cnt += (candidate & j) > 0 ? 1 : 0;
    
    console.log({j, cnt})
    res = Math.max(res, cnt);
  }
  
  return res;
};
*/

function largestCombination(candidates: number[]): number {
  let max = 0;
  
  for(let i = 0; i < 32; i++){
    let currMax = 0;
    
    for(let candidate of candidates)
      if(((candidate >> i) & 1) == 1)
        currMax++;
    max = Math.max(max, currMax);
  }

  return max;
}
