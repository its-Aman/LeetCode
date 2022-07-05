function longestConsecutive(nums: number[]): number {
	const N = nums.length,
	    	set = new Set<number>(nums);

  let ans = 0;

	for (let num of set.values()) {
		
    if (!set.has(num - 1)) {
			let curr = num,
				cnt = 1;

			while (set.has(curr + 1)) {
				cnt += 1;
				curr += 1;
			}

			ans = Math.max(ans, cnt);
		}
	}

	return ans;
};