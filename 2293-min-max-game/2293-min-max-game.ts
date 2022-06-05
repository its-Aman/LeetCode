function minMaxGame(nums: number[]): number {
  let N = nums.length;
  
  if(N == 1)
    return nums[0];

  while(N != 1){
    N >>= 1;
    for(let i = 0; i < N; i++){
      if(i % 2 == 0)
        nums[i] = Math.min(nums[2 * i], nums[2 * i + 1])
      else
        nums[i] = Math.max(nums[2 * i], nums[2 * i + 1])
    }
  }
  return nums[0];
}

function minMaxGame_BF(nums: number[]): number {
  const N = nums.length;
  let i = 0, temp = [];

  if(N == 1)
    return nums[0];
  
  while(i < Math.log2(N)){
    temp = [];
    for(let i = 0; i < nums.length; i+= 2){
      if(i % 4 == 0)
        temp.push(Math.min(nums[i], nums[i + 1]));
      else
        temp.push(Math.max(nums[i], nums[i + 1]));

    }
    // console.log({temp, i})
    nums = temp;
    i++;
  }
  
  return temp[0];

};