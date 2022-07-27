class Solution {
	public int coinChange(int[] coins, int amount) {
		int N = coins.length;
		int[] dp = new int[1 + amount];

		Arrays.sort(coins);
		Arrays.fill(dp, 1 + amount);

		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {

			for (int j = 0; j < N && coins[j] <= i; j++) {
				dp[i] = Math.min(1 + dp[i - coins[j]], dp[i]);
			}
		}
    
		return dp[amount] > amount ? -1 : dp[amount];
	}
}