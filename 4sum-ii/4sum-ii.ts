function fourSumCount(nums1: number[], nums2: number[], nums3: number[], nums4: number[]): number {  
  const map = new Map<number, number>();
  let ans = 0;
  
  for(let a of nums1){
    for(let b of nums2){
      const sum = a + b;
      if(!map.has(sum))
        map.set(sum, 1);
      else
        map.set(sum, map.get(sum) + 1)
    }
  }

  for(let c of nums3){
    for(let d of nums4){
      const sum = - c - d;
      if(map.has(sum))
        ans += map.get(sum);
    }
  }

  return ans;
};

/*
a b c d

a + b + c + d = 0

a + b = - c - d

*/