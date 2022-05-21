/*
// Noob answer: 

function longestConsecutive(nums: number[]): number {
  if(!nums || nums.length == 0)
    return 0;
  
  const N = nums.length,
        max = Math.max(...nums),
        arr = new Array(max).fill(false);
  
  let result = 0;
  
  for(let i = 0; i < N; i++)
    arr[nums[i]] = true;
    
  for(let i = 0; i < N; i++){
    let currMax = 0,
        j = nums[i];
    
    while(arr[j]){
      // console.log({i, currMax, j})
      currMax++;
      j++
    }
    
    result = Math.max(result, currMax);
  }
  return result;
};
*/
function longestConsecutive(nums: number[]): number {
  const N = nums.length,
        set = new Set(nums);
  
  let max = 0;
  
  for(let num of nums){
    let currMax = 1;
    if(!set.has(num + 1)){
      while(set.has(num - 1)){
        currMax++;
        num--;
      }
    }
    max = Math.max(max, currMax);
  }
  return max;
};