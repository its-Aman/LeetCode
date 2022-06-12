// https://leetcode.com/problems/fair-distribution-of-cookies/discuss/2140918/Easy-C%2B%2B-or-Backtracking

function distributeCookies(cookies: number[], K: number): number {
  const N = cookies.length;

  let ans = Number.MAX_SAFE_INTEGER;
  
  dfs(0, new Array(K).fill(0));
  
  return ans;
  
  function dfs(start: number, bags: number[]): void {
    // console.log({start, bags})
    if(start == N) {
      ans = Math.min(ans, Math.max(...bags));      
      // console.log({ans}, "--------------------")
      return;
    }
    
    for(let i = 0; i < K; i++) {
      bags[i] += cookies[start];
      dfs(start + 1, bags.slice(0));
      bags[i] -= cookies[start];
    }
  }
  
};