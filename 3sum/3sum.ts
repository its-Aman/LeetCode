function threeSum(nums: number[]): number[][] {
  let N = nums.length,
      ans = [];
  
  if(N < 3)
    return ans;
  
  nums.sort((a, b) => a - b);
  
  for(let i = 0; i < N - 2; i++){
    let a = nums[i];
    
    if(a > 0)
      return ans;
    
    if(a == nums[i-1])
      continue;
    
    for(let j = i + 1, k = N - 1; j < k;){
      let b = nums[j],
          c = nums[k],
          result = a + b + c;
      
      if(result == 0){
        ans.push([a, b, c]);        
        j++;
        k--;
        
        while(j < k && nums[j] == nums[j - 1])
          j++;

        while(j < k && nums[k] == nums[k + 1])
          k--;
        
      } else if (result > 0){
        k--;
      } else {
        j++
      }
    }
    
  }
  
  return ans;
};