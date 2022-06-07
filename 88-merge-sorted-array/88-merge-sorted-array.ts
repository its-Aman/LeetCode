/**
 Do not return anything, modify nums1 in-place instead.
 */
function merge(n1: number[], m: number, n2: number[], n: number): void {
  let i = m - 1, 
      j = n - 1,
      k = m + n - 1;
  
  while(j >= 0 && i >= 0){
    if(n1[i] < n2[j])
      n1[k--] = n2[j--];
    else
      n1[k--] = n1[i--];
  }

  while(j >= 0)
    n1[k--] = n2[j--];
};