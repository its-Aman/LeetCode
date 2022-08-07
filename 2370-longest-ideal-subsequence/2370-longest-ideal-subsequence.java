class Solution {
	public int longestIdealString(String S, int K) {
		int[] dp = new int[26];
		int ans = 1;

		for (char ch : S.toCharArray()) {
			int idx = ch - 'a';
			dp[idx] += 1;

			for (int i = Math.max(idx - K, 0); i <= Math.min(idx + K, 25); i++) {
				if (idx != i)
					dp[idx] = Math.max(dp[idx], 1 + dp[i]);
			}
			
			ans = Math.max(ans, dp[idx]);
		}

		return ans;
	}
}