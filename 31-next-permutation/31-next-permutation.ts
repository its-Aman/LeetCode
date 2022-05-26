/**
 Do not return anything, modify nums in-place instead.
 */
function nextPermutation(nums: number[]): void {
  const N = nums.length;
  let i = N - 2,
      j = 0;

  if(N == 1){
    return;    
  }
  
  if(N == 2){
    if(nums[0] > nums[1]) 
      swap(0, 1);
  }
  
  while(i >= 0 && nums[i] >= nums[i + 1])
    i--;

  // if(i == 0){
  //   nums.reverse();    
  //   return;
  // }
  
  j = i + 1;

  while(j < N && nums[j] > nums[i])
    j++;

  swap(i, j - 1);

  i = i + 1;
  j = N - 1;

  while(i <= j){
    swap(i, j);
    i++;
    j--;
  }

  function swap(i: number, j: number): void {
    let temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}