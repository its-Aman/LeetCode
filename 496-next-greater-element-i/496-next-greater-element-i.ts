function nextGreaterElement(nums1: number[], nums2: number[]): number[] {
  const stack = [],
        N1 = nums1.length,
        N2 = nums2.length,
        map = new Map<number, number>();

  let i = N2 - 1;
  
  while(i >= 0){
    // if(stack.length == 0){
    //   map.set(nums2[i], -1);
    // } else if(stack[stack.length - 1] > nums2[i]){
    //   map.set(nums2[i], stack[stack.length - 1]);
    // } else {
      while(stack.length != 0 && (stack[stack.length - 1] <= nums2[i]))
        stack.pop();
      map.set(nums2[i], stack.length > 0 ? stack[stack.length - 1] : -1);
    // }
    stack.push(nums2[i]);
    i--;
  }
  
  return nums1.map(e => map.get(e));
};