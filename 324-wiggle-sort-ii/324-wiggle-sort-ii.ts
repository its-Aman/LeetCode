/**
 Do not return anything, modify nums in-place instead.
 */
function wiggleSort(nums: number[]): void {
  const N = nums.length,
        M = (N + 1) >>> 1,
        copy = nums.slice(0),
        median = kthSmallestElement(copy, M);

  for(let i = 0, j = 0, k = N - 1; j <= k;)
    if(copy[j] < median)
      swap(copy, i++, j++);
    else if(copy[j] > median)
      swap(copy, j, k--);
    else
      j++;

  for(let i = M - 1, j = 0; i >= 0; i--, j += 2)
    nums[j] = copy[i];

  for(let i = N - 1, j = 1; i >= M; i--, j += 2)
    nums[j] = copy[i];

};

function kthSmallestElement(nums: number[], k: number): number {
  const rand = (i) => (~~(Math.random() * (5*10e4))) % i;
  
  for(let i = nums.length - 1; i >= 0; i--)
    swap(nums, i, rand(i + 1));
  
  let l = 0,
      r = nums.length - 1;

  k--;
  
  while(l < r){
    const m = getMiddle(nums, l, r);
    
    if(m < k)
      l = m + 1;
    else if(m > k)
      r = m - 1;
    else
      break;
  }
  
  return nums[k];
}

function getMiddle(nums: number[], l: number, r: number): number {
  let i = l;
  for(let j = l + 1; j <= r; j++)
    if(nums[j] < nums[l])
      swap(nums, ++i, j);
  
  swap(nums, l, i);
  return i;
}

function swap(nums: number[], i: number, j: number): void {
  const t = nums[i];
  nums[i] = nums[j];
  nums[j] = t;
}