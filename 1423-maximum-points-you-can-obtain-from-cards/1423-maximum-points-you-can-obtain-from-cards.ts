function maxScore(cardPoints: number[], K: number): number {
  const N = cardPoints.length,
        prefixSum = new Array(N + 1).fill(0);
  
  let ans = 0;
  
  prefixSum[0] = 0;
  
  for(let [i, ptx] of cardPoints.entries())
    prefixSum[i + 1] = prefixSum[i] + ptx;
  
  // console.log(prefixSum);
  
  for(let i = 0; i <= K; i++) {
    const j = N - K + i;
    // console.log(i, j, ans, prefixSum[i], prefixSum[N], prefixSum[j])
    ans = Math.max(ans, prefixSum[i] + (prefixSum[N] - prefixSum[j]))
  }
  
  return ans;
};