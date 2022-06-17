/**
 * input: 1 2 1 2 1
 * ways:  1 2 3 5 8
 *
 * Cases:
 * 1) ways[n] = ways[n-1] + ways[n-2] iff 10 <= s[n-1] + s[n] <= 26 - eg xx10, xx11, xx25, xx26
 * 2) ways[n] = ways[n-1]             iff s[n-1] + s[n] > 26 - eg xx27
 * 3) ways[n] = ways[n-2]             iff s[n] === 0 && (s[n-1] === 1 || s[n-1] === 2) - eg xx20
 * 4) ways[n] = 0                     iff s[n] === 0 && s[n-1] > 2 - eg xx30
 *
 * @note s[n-1] === 0 is covered by larger sub-problem in case 3.
 * @note s[0] === 0 => return 0 immediately
 */

function numDecodings(s: string): number {
  if (s[0] === "0") return 0;

  let waysN_2 = 1;
  let waysN_1 = 1;
  let waysN = 1;


  for (let n = 2; n <= s.length; n++) {
    if (s[n - 1] === "0") {
      if (["1", "2"].includes(s[n - 2]))
        waysN = waysN_2;
      else
        return 0;
    } else {
      const sum = Number(s[n - 2] + s[n - 1]);
      waysN = waysN_1 + (10 <= sum && sum <= 26 ? waysN_2 : 0);
    }
      
    waysN_2 = waysN_1;
    waysN_1 = waysN;
  }

  return waysN;
};