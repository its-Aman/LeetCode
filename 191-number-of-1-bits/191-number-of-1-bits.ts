function hammingWeight(n: number): number {
  let ans = 0;
  
  while(n > 0){
    if((n & 1) == 1)
      ans++
    n >>>= 1;
    // console.log(n.toString(2))
  }
  return ans;
};