function maximumsSplicedArray_mine(nums1: number[], nums2: number[]): number {
  const N = nums1.length,
        temp1 = new Array<number>(N + 1).fill(0),
        temp2 = new Array<number>(N + 1).fill(0);
  let sum1 = 0,
      sum2 = 0;
  
  for(let i = 0; i < N; i++) {
    sum1 += nums1[i];
    sum2 += nums2[i];

    const diff = nums1[i] - nums2[i];
    temp1[i + 1] = Math.max(0, -1 * diff + temp1[i]);
    temp2[i + 1] = Math.max(0, diff + temp2[i]);
  }
  
  return Math.max(sum1 + Math.max(...temp1), sum2 + Math.max(...temp2));
};

function maximumsSplicedArray(nums1: number[], nums2: number[]): number {
  
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