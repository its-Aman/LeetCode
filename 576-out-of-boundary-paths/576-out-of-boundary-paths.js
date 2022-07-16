/**
 * @param {number} m
 * @param {number} n
 * @param {number} maxMove
 * @param {number} startRow
 * @param {number} startColumn
 * @return {number}
 */
var findPaths = function(M, N, maxMove, i, j) {
    const memo = Array.from(new Array(M), () => Array.from(new Array(N), () => new Array(maxMove + 1).fill(BigInt(-1)))), 
          MOD = 1000000007, 
          dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]],
          ans = findPathsDFS(M, N, maxMove, i, j, memo);
    
  return Number(ans) % MOD;
  
  function findPathsDFS(M, N, maxMove, i, j) {
      if (i == M || j == N || i < 0 || j < 0)
          return BigInt(1);
      if (maxMove == 0)
          return BigInt(0);
      if (memo[i][j][maxMove] >= 0)
          return memo[i][j][maxMove];
      memo[i][j][maxMove] = BigInt(0);
      for (let [x, y] of dirs)
          memo[i][j][maxMove] += findPathsDFS(M, N, maxMove - 1, i + x, j + y, memo) % BigInt(MOD);
      return BigInt(memo[i][j][maxMove]);
  }
};