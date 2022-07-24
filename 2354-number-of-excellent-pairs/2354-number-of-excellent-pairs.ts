// https://leetcode.com/problems/number-of-excellent-pairs/discuss/2324984/JavaC%2B%2BPython-Inclusion-Exclusion-Principle

function countExcellentPairs(nums: number[], K: number): number {
  const N = nums.length,
        set = new Set(nums),
        cnt = new Array(30).fill(0);
  let ans = 0;

  for(let item of set)
    cnt[countSetBits(item)] += 1;
  
  for(let i = 0; i < 30; i++)
    if(cnt[i])
      for(let j = 0; j < 30; j++)
        if(i + j >= K)
          ans += cnt[i] * cnt[j];
  
  return ans;
};

function countSetBits(N: number) {
  let count = 0,
      num = N;
  
  while (num) {
    count += num & 1;
    num >>= 1;
  }
  
  return count;
}