class Solution {

	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		return this.minRefuelStops_heap(target, startFuel, stations);
	}

	private int minRefuelStops_dp(int target, int startFuel, int[][] stations) {
		/*
		 * Approach 1: 1D DP, O(N^2)
		 * 
		 * dp[t] means the furthest distance that we can get with t times of refueling.
		 * 
		 * So for every station s[i], 
		 * 
		 * if the current distance dp[t] >= s[i][0], we can refuel: 
		 *
		 ** dp[t + 1] = max(dp[t + 1], dp[t] + s[i][1])
		 * 
		 * In the end, we'll return the first t with dp[t] >= target, 
		 ** otherwise we'll return -1.
		 */

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

	private int minRefuelStops_heap(int target, int startFuel, int[][] stations) {
		/*
		 * Approach 2: Priority Queue, O(NlogN)
		 * 
		 * i is the index of next stops to refuel. 
		 * 
		 * res is the times that we have refeuled. 
		 * 
		 * pq is a priority queue that we store all available gas.
		 * 
		 * 
		 * We initial res = 0 and in every loop:
		 * 
		 ** We add all reachable stop to priority queue. 
		 ** We pop out the largest gas from pq and refeul once. 
		 ** If we can't refuel, means that we can not go forward and return -1
		 */
		int i = 0, res = 0, N = stations.length;
		Queue<Integer> pq = new PriorityQueue<Integer>();

		for (res = 0; startFuel < target; res += 1) {

			while (i < stations.length && stations[i][0] <= startFuel)
				pq.offer(-stations[i++][1]);

			if (pq.isEmpty())
				return -1;

			startFuel += -pq.poll();
		}

		return res;
	}
}
