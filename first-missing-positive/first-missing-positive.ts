function firstMissingPositive(nums: number[]): number {
  const N = nums.length;
  
  for(let i = 0; i < nums.length; i++){
    while(nums[i] > 0 && nums[i] <= N && nums[nums[i] - 1] != nums[i]){
      let temp = +nums[i];
      nums[i] = +nums[temp - 1]
      nums[temp - 1] = temp;
    }
  }
  
  for(let i = 0; i < N; i++)
    if(nums[i] != (i + 1))
      return i + 1;
  
  return N + 1;
};