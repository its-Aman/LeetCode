func findNumberOfLIS(nums []int) int {
	N := len(nums)
	length, count := make([]int, N), make([]int, N)

	for i := 0; i < N; i++ {
		length[i] = 1
		count[i] = 1
	}

	for i := 0; i < N; i++ {
		for j := 0; j < i; j++ {
			if nums[j] < nums[i] {
				if length[j]+1 > length[i] {
					length[i] = length[j] + 1
					count[i] = 0
				}

				if length[j]+1 == length[i] {
					count[i] += count[j]
				}
			}
		}
	}

	maxLen, ans := 0, 0

	for _, len := range length {
		maxLen = max(maxLen, len)
	}

	for i := 0; i < N; i++ {
		if length[i] == maxLen {
			ans += count[i]
		}
	}

	return ans
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
