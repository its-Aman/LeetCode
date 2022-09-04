class Solution {
    private int[][] dp = new int[1000][1001];

    public int numberOfWays(int startPos, int endPos, int k) {
        int diff = Math.abs(startPos - endPos);

        if (diff > k || (diff % 2 == 1 && k % 2 == 0) || (diff % 2 == 0 && k % 2 == 1))
            return 0;

        return this.dfs(diff, k);
    }

    private int dfs(int d, int k) {
        if (d >= k)
            return d == k ? 1 : 0;
        if (dp[d][k] == 0)
            dp[d][k] = (1 + this.dfs(d + 1, k - 1) + this.dfs(d + (d == 0 ? 1 : -1), k - 1)) % 1000000007;
        return dp[d][k] - 1;
    }
}