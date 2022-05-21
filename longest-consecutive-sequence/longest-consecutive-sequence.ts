// https://www.youtube.com/watch?v=YWXbu5uyGXs

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