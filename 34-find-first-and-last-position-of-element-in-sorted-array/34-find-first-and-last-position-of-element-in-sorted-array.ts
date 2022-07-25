function searchRange(nums: number[], K: number): number[] {
  return [lower_bound(nums, K), upper_bound(nums, K)];
};

function lower_bound(arr: number[], K: number): number {
  const N = arr.length;
  let low = 0,
      hi = N;
  
  while(low < hi) {
    const mid = low + Math.floor((hi - low) / 2);
    
    if(arr[mid] >= K)
      hi = mid;
    else
      low = 1 + mid;
  }

  if(low < N && arr[low] < K)
    low += 1
  
  if(arr[low] == K)
    return low;
  else
    return -1;
}

function upper_bound(arr: number[], K: number): number {
  const N = arr.length;
  let low = 0,
      hi = N;
  
  while(low < hi) {
    const mid = low + Math.floor((hi - low) / 2);
    
    if(arr[mid] <= K)
      low = 1 + mid;
    else
      hi = mid;
  }

  if(low < N && arr[low] <= K)
    low += 1;
  
  if(arr[low - 1] == K)
    return low - 1;
  else
    return -1;  
}
