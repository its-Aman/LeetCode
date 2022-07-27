class Solution {
	public int coinChange(int[] coins, int amount) {
		int N = coins.length;
		int[] dp = new int[1 + amount];

		Arrays.fill(dp, 1 + amount);

		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {

			for (int coin : coins) {
				if (coin > i)
					continue;

				dp[i] = Math.min(1 + dp[i - coin], dp[i]);
			}
		}

		return dp[amount] > amount ? -1 : dp[amount];
	}

}