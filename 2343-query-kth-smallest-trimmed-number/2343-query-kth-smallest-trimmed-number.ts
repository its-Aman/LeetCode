function smallestTrimmedNumbers(nums: string[], queries: number[][]): number[] {
  const N = nums.length,
        M = nums[0].length,
        ans = new Array<number>(0);
  
  for(let [k, trim] of queries) {
    const processedArr = nums.map(num => num.slice(M - trim))
                    .map((item, i)=>[BigInt(item), BigInt(i)])
                    .sort(([a1, b1], [a2, b2]) => a1 == a2 ? sortFn(b1, b2) : sortFn(a1, a2));
    
    ans.push(Number(processedArr[k - 1][1]));
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