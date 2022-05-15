// https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/discuss/2039740/Sentinels

function maxConsecutive(bottom: number, top: number, special: number[]): number {
  let N = special.length;
  
  special.sort((a,b) => a-b);
  let max = Math.max(special[0] - bottom, top - special[N - 1]);

  for(let i = 1; i < N; i++){
    max = Math.max(max, special[i] - special[i - 1] - 1);
  }
  
  return max;
};