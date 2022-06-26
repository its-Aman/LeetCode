function maximumXOR(nums: number[]): number {
  return nums.reduce((a, c) => a |= c);
}

function maximumXOR_old(nums: number[]): number {
  let bits = new Array(32).fill(0),
      mask = 0;
  
  for(let num of nums) {
    for(let i = 0; i < 32; i++) {
      if(num & (1 << i))
        bits[i]++;
      
      // console.log({num, i, sft: 1 << i, and: num & (1 << i), b: bits[i]})
    }
    // console.log(bits)
  }
  
  for(let i = 0; i < 32; i++) {
    if(bits[i])
      mask |= (1 << i);
    // console.log({mask, b: bits[i], sft: 1 << i})
  }

  return mask;
};