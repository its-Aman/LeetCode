/**
 * @param {number} h
 * @param {number} w
 * @param {number[]} horizontalCuts
 * @param {number[]} verticalCuts
 * @return {number}
 */
var maxArea = function(H, W, hCuts, vCuts) {
  const MOD = 1000000007n;
  
  return (getMax(H, hCuts) * getMax(W, vCuts)) % MOD;

  function getMax(N, nCuts) {
    const nN = nCuts.length;

    nCuts.sort((a, b) => a - b);

    let maxN = Math.max(N - nCuts[nN - 1], nCuts[0]);

    for(let i = 1; i < nN; i++)
      maxN = Math.max(maxN, nCuts[i] - nCuts[i - 1]);

    return BigInt(maxN);
  }
}