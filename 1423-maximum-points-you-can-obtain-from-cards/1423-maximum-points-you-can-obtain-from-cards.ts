function maxScore(cardPoints: number[], K: number): number {
  const N = cardPoints.length,
        prefixSum = new Array(N + 1).fill(0);
  
  let ans = 0;
  
  for(let [i, ptx] of cardPoints.entries())
    prefixSum[i + 1] = prefixSum[i] + ptx;
  
  for(let i = 0; i <= K; i++)
    ans = Math.max(ans, prefixSum[i] + (prefixSum[N] - prefixSum[N - K + i]))
  
  return ans;
};