class Solution {
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		int N = stations.length;
		long[] dp = new long[N + 1];

		dp[0] = startFuel;

		for (int i = 0; i < N; ++i)
			for (int t = i; t >= 0 && dp[t] >= stations[i][0]; --t)
				dp[t + 1] = Math.max(dp[t + 1], dp[t] + stations[i][1]);

		for (int t = 0; t <= N; ++t)
			if (dp[t] >= target)
				return t;

		return -1;
	}
}


/*

    N
    
W   +   E
    
    S

*/