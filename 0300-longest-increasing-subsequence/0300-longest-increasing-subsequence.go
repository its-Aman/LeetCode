func lengthOfLIS(nums []int) int {
	N, idx := len(nums), 0
	dp := make([]int, N)

	addNumberToAppropriatePlace := func(num, hi int) int {
		lo := 0
		for lo < hi {
			mid := lo + (hi-lo)/2
			if num <= dp[mid] {
				hi = mid
			} else {
				lo = mid + 1
			}
		}
		return lo
	}

	for _, num := range nums {
		if idx == 0 || dp[idx-1] < num {
			dp[idx] = num
			idx++
		} else {
			newIdx := addNumberToAppropriatePlace(num, idx)
			dp[newIdx] = num
		}
	}

	return idx
}
