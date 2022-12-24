class Solution {
    int MOD = 1_000_000_007;
    int[][] dp;

    public int numTilings(int n) {
        dp = new int[n + 1][2];
        long ans = solve(n, 0);
        return (int)(ans % MOD);
    }

    private long solve(int idx, int prevGap) {
        if (idx < 0) {
            return 0l;
        }

        if (idx == 0) {
            return 1l - prevGap;
        }

        if (dp[idx][prevGap] != 0) {
            return dp[idx][prevGap];
        }

        if (prevGap == 1) {
            return dp[idx][prevGap] = (int)((solve(idx - 1, 0) + solve(idx - 1, 1)) % MOD);
        }

        return dp[idx][prevGap] = (int)((solve(idx - 1, 0) + solve(idx - 2, 0) + 2 * solve(idx - 2, 1)) % MOD);
    }
}