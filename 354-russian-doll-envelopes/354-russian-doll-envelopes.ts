// https://leetcode.com/problems/russian-doll-envelopes/discuss/1134011/JS-Python-Java-C%2B%2B-or-Easy-LIS-Solution-w-Explanation

function maxEnvelopes(envelopes: number[][]): number {
  envelopes.sort((a,b) => (a[0] == b[0] ? (b[1]-a[1]) : a[0] - b[0]));
  
  const dp = [],
        N = envelopes.length;
  
  for(let i = 0; i < N; i++){
    let h = envelopes[i][1],
        l = 0,
        r = N;
    
    while(l < r){
      const m = (l + r) >> 1;
      if(dp[m] < h)
        l = m + 1;
      else 
        r = m
    }
    dp[l] = h;
  }
  return dp.length;
};