// https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/445769/merge-sort-CLEAR-simple-EXPLANATION-with-EXAMPLES-O(n-lg-n)

// https://www.youtube.com/watch?v=_sA1xI4XK0c

function countSmaller(nums: number[]): number[] {
  const N = nums.length,
        count = new Array(N).fill(0),
        v = buildPair(nums);
  
  mergeSort(count, v, 0, N - 1);
  
  return count;
};

function mergeSort(count: number[], v: number[][], l: number, r: number): void {
  if(l < r){
    const m = Math.floor(l + (r - l) / 2);
    mergeSort(count, v, l, m);
    mergeSort(count, v, m + 1, r);
    merge(count, v, l, m, r);
  }
}

function merge(count: number[], v: number[][], l: number, m: number, r: number): void {
  const merged = Array(r - l + 1);
  let i = l,
      j = m + 1,
      k = 0;

  while(i <= m && j <= r) {
    if(v[i][1] <= v[j][1]){
      merged[k++] = v[j++];
    } else {
      count[v[i][0]] += r - j + 1;
      merged[k++] = v[i++];
    }
  }

  while(i <= m)
    merged[k++] = v[i++];

  while(j <= r)
    merged[k++] = v[j++];

  for(let i = l; i <= r; i++)
    v[i] = merged[i - l];

}

function buildPair(arr: number[]): number[][] {
  const res = [];

  for(let [i, v] of arr.entries())
    res.push([i, v]);

  return res;
}
