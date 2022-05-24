// 1. https://leetcode.com/problems/ones-and-zeroes/discuss/95845/Easy-to-understand-Recursive-Solutions-in-Java-with-Explanation
// 2. https://leetcode.com/problems/ones-and-zeroes/discuss/1138589/Short-and-Easy-w-Explanation-or-O(L*m*n)-DP-solution-(6-lines)-similar-to-knapsack

function findMaxForm(strs: string[], m: number, n: number): number {
  const dp = Array.from(Array(m + 1), () => Array.from(Array(n + 1), () => new Array(strs.length).fill(0))),
        map = new Map<string, number[]>();
  setMap();
  return knapsack(m, n, 0);

  function knapsack(m: number, n: number, begin: number): number{
    if(begin == strs.length || ((m == 0) && (n == 0)))
      return 0;
    
    if(dp[m][n][begin])
      return dp[m][n][begin];
      
    const current = strs[begin],
          [_m, _n] = map.get(current);

    dp[m][n][begin] = knapsack(m, n, begin + 1);

    if(m >= _m && n >= _n)
      dp[m][n][begin] = Math.max(dp[m][n][begin], (1 + knapsack(m - _m, n - _n, begin + 1)));

    
    return dp[m][n][begin];
  }

  function setMap(): void {
    for (let str of strs) {
        let m = 0;
        for (let c of str)
            if (c == '0')
                m++;
        map.set(str, [m, str.length - m]);
    }
  }
}