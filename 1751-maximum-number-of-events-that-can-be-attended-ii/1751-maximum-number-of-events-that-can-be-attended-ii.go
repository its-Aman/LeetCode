func maxValue(events [][]int, k int) int {
	N := len(events)
	dp := make([][]int, k+1)
	var bisectRight func(target int) int

	for i, _ := range dp {
		dp[i] = make([]int, N+1)
	}

	sort.Slice(events, func(i, j int) bool { return events[i][0] < events[j][0] })

	bisectRight = func(target int) int {
		l, r := 0, N
		for l < r {
			m := l + (r-l)/2
			if events[m][0] <= target {
				l = m + 1
			} else {
				r = m
			}
		}
		return l
	}

	for i := N - 1; i >= 0; i-- {
		for cnt := 1; cnt <= k; cnt++ {
			j := bisectRight(events[i][1])
			dp[cnt][i] = max(dp[cnt][i+1], events[i][2]+dp[cnt-1][j])
		}
	}
	return dp[k][0]
}

func maxValue2(events [][]int, k int) int {
	N := len(events)
	var dfs func(i, cnt int) int
	var bisectRight func(target int) int
	dp := make([][]int, k+1)

	for i, _ := range dp {
		dp[i] = make([]int, N)
		for j, _ := range dp[i] {
			dp[i][j] = -1
		}
	}

	sort.Slice(events, func(i, j int) bool { return events[i][0] < events[j][0] })

	bisectRight = func(target int) int {
		l, r := 0, N
		for l < r {
			m := l + (r-l)/2
			if events[m][0] <= target {
				l = m + 1
			} else {
				r = m
			}
		}
		return l
	}

	dfs = func(i, cnt int) int {
		if i == N || cnt == 0 {
			return 0
		}
		if dp[cnt][i] != -1 {
			return dp[cnt][i]
		}

		j := bisectRight(events[i][1])
		dp[cnt][i] = max(dfs(i+1, cnt), events[i][2]+dfs(j, cnt-1))
		return dp[cnt][i]
	}

	return dfs(0, k)
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
