function smallestTrimmedNumbers(nums: string[], queries: number[][]): number[] {
  const N = nums.length,
        M = nums[0].length,
        ans = new Array<number>(0);
  
  for(let [k, trim] of queries) {
    const trimmed = nums.map(num => BigInt(num.slice(M - trim)));
    const mapped = trimmed.map((item,i)=>[BigInt(item), BigInt(i)]);
    const sortedMapped = mapped.sort(([a1,b1],[a2,b2]) => a1 == a2 ? sortFn(b1, b2) : sortFn(a1, a2));
    
    ans.push(Number(mapped[k - 1][1]));
  }
  
  return ans;

  function sortFn(a: BigInt, b: BigInt): number {
    if(a > b)
      return 1;
    else if(a < b)
      return -1
    else
      return 0;
  }
};