function twoSum(numbers: number[], target: number): number[] {

  for(let [i, num] of numbers.entries()){
    const j = binarySearch(i + 1, numbers.length - 1, target - num);
    // console.log({num, i, j});
    
    if(~j)
      return [i + 1, j + 1];
    else
      continue;
  }
  
  return [-1, -1];
  
  function binarySearch(lo: number, hi: number, num: number): number {
    if(lo > hi)
      return -1;
    
    const mid = lo + ((hi-lo) >> 1);
    
    // console.log({lo, mid, hi, num})
    if(numbers[mid] == num)
      return mid;
    else if(num > numbers[mid])
      return binarySearch(mid + 1, hi, num);
    else
      return binarySearch(lo, mid - 1, num);
  }
  
};
