function countSmaller(nums: number[]): number[] {
  const N = nums.length,
        ans = new Array(N).fill(0),
        pairs = new Array(0);

  for(let [i, v] of nums.entries())
    pairs.push([i, v]);
  
  mergeSort(0, N - 1);
  
  return ans;
  
  function mergeSort(l: number, r: number): void {
    if(l < r) {
      const m = l + Math.floor((r - l) / 2);
      mergeSort(l, m);
      mergeSort(1 + m, r);
      merge(l, m, r);
    }
  }

  function merge(l: number, m: number, r: number): void {
    const merged = new Array(r - l + 1);
    let i = l,
        j = 1 + m,
        k = 0;
    
    while(i <= m && j <= r) {
      if(pairs[i][1] <= pairs[j][1]) {
        merged[k++] = pairs[j++];
      } else {
        ans[pairs[i][0]] += r - j + 1;
        merged[k++] = pairs[i++];
      }
    }

    while(i <= m)
      merged[k++] = pairs[i++];

    while(j <= r)
      merged[k++] = pairs[j++];

    for(let i = l; i <= r; i++)
      pairs[i] = merged[i - l];

  }
}  
