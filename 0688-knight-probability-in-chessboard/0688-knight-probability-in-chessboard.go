func knightProbability(n, k, row, column int) float64 {
	dirs := [][]int{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}}
	dp := make([][][]float64, k+1)
	
    for moves := 0; moves <= k; moves++ {
		dp[moves] = make([][]float64, n)
		for i := 0; i < n; i++ {
			dp[moves][i] = make([]float64, n)
			for j := 0; j < n; j++ {
				dp[moves][i][j] = 0.0
			}
		}
	}

    dp[0][row][column] = 1.0

	for moves := 1; moves <= k; moves++ {
		for i := 0; i < n; i++ {
			for j := 0; j < n; j++ {
				for _, dir := range dirs {
					prevI, prevJ := i-dir[0], j-dir[1]

					if prevI >= 0 && prevI < n && prevJ >= 0 && prevJ < n {
						dp[moves][i][j] += dp[moves-1][prevI][prevJ] / 8.0
					}
				}
			}
		}
	}

	ans := 0.0

	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			ans += dp[k][i][j]
		}
	}

	return ans
}