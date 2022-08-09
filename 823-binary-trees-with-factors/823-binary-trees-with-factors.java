class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
		long MOD = 7 + (long) Math.pow(10, 9);
		int N = arr.length;
		long[] dp = new long[N];
		Map<Integer, Integer> map = new HashMap<>();
		long ans = 0;
        
		Arrays.sort(arr);
		Arrays.fill(dp, 1);

		for (int i = 0; i < N; i++)
			map.put(arr[i], i);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
					dp[i] = (dp[i] + dp[j] * dp[map.get(arr[i] / arr[j])]) % MOD;
				}
			}
			ans += dp[i] % MOD;
		}

		return (int) (ans % MOD);
	}
}