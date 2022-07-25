function threeSum(nums: number[]): number[][] {
  const N = nums.length,
        ans = new Map<string, number[]>(),
        set = new Set<number>();
  
  nums.sort((a, b) => a - b);
  
  for(let i = 0; i < N; i++) {
    const a = nums[i];
    set.clear();
    
    for(let j = i + 1; j < N; j++) {
      const b = nums[j],
            c = -(a + b);
      
      if(set.has(c))
        ans.set([a, b, c].join(''), [a, b, c]);
      
      set.add(b);
    }
    
  }
  
  return Array.from(ans.values());
};