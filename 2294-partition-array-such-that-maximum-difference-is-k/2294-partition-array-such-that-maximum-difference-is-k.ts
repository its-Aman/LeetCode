function partitionArray(nums: number[], K: number): number {
  // sort the array so that the subsequences can be found easily.
  
  nums.sort((a, b) => a - b);
  const N = nums.length;

  // we'll be having a single subsequence of the array, 
  // if consider the whole array.
  let ans = 1;
  
  for(let i = 1, j = 0; i < N; i++){
    
    // if we've found an item such that the sum is greater then K
    // that means we've found one such sequence and we need to update the 
    // ans and also we've to start a new sequence so that remaining subsequences can be count further.
    
    if(nums[i] - nums[j] > K){
      // increase the count.
      ans++;
      // reset the subsequence shortest element.
      j = i;
    }
  }
  
  return ans;
}

function partitionArray_1(nums: number[], K: number): number {
  nums.sort((a, b) => a - b);
  const N = nums.length;
  
  let ans = 1,
      mn = nums[0],
      mx = nums[0];
  
  for(let num of nums) {
    mx = Math.max(mx, num);
    mn = Math.min(mn, num);
    if(mx - mn > K){
      console.log({mx, mn, ans})
      mx = mn = num;
      ans++;
    }
  }
  
  return ans;
};