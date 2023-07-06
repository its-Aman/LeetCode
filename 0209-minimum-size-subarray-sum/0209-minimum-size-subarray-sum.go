func minSubArrayLen(target int, nums []int) int {
	ans, left, sum := math.MaxInt, 0, 0

	for i, num := range nums {
		// fmt.Printf("i= %d \t num=%d\n", i, num)
		sum += num
		for sum >= target {
			ans = min(ans, i-left+1)
			sum -= nums[left]
			left++
		}
	}

	if ans == math.MaxInt {
		return 0
	}
	return ans
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}
