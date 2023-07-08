func putMarbles(weights []int, k int) int64 {
	N := len(weights)
	pairWeight := make([]int, N-1)
	for i := 0; i < N-1; i++ {
		pairWeight[i] = weights[i] + weights[i+1]
	}
	sort.Ints(pairWeight)
	var ans int64 = 0

	for i := 0; i < k-1; i++ {
		ans += int64(pairWeight[N-2-i] - pairWeight[i])
	}

	return ans
}
