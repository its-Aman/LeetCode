func eraseOverlapIntervals(intervals [][]int) int {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][1] < intervals[j][1]
	})
    
	ans, k := 0, math.MinInt

	for _, interval := range intervals {
		if interval[0] >= k {
			k = interval[1]
		} else {
			ans++
		}
	}

	return ans
}
