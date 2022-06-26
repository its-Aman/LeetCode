function maximumsSplicedArray(nums1: number[], nums2: number[]): number {
  let N = nums1.length,
      temp1 = 0,
      temp2 = 0,
      sum1 = 0,
      sum2 = 0,
      res1 = 0,
      res2 = 0;
  
  for(let i = 0; i < N; i++) {
    sum1 += nums1[i];
    sum2 += nums2[i];

    const diff = nums1[i] - nums2[i];
    
    temp1 = Math.max(0, -1 * diff + temp1);
    res1 = Math.max(res1, temp1);
    
    temp2 = Math.max(0, diff + temp2);
    res2 = Math.max(res2, temp2);
  }
  
  return Math.max(sum1 + res1, sum2 + res2);
};

function maximumsSplicedArray_rec(nums1: number[], nums2: number[]): number {
  
  return Math.max(kadane(nums1, nums2), kadane(nums2, nums1));
  
  function kadane(A: number[], B: number[]): number {
    let res = 0,
        curr = 0,
        sum = 0;
    
    for(let i = 0; i < A.length; i++) {
      sum += B[i];
      curr = Math.max(0, curr + A[i] - B[i]);
      res = Math.max(res, curr);
    }
    
    return res + sum;
  }
};