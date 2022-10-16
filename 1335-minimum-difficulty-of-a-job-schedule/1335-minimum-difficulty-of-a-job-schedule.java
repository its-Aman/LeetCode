class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int N = jobDifficulty.length;

        if (N < d)
            return -1;

        int[][] dp = new int[N][d + 1];

        for (var _dp : dp)
            Arrays.fill(_dp, -1);

        return dfs(d, 0, jobDifficulty, dp);
    }

    private int dfs(int daysLeft, int currDifficultyIdx, int[] jobDifficulty, int[][] dp) {
        if (daysLeft == 0 && currDifficultyIdx == jobDifficulty.length)
            return 0;

        if (daysLeft == 0 || currDifficultyIdx == jobDifficulty.length)
            return Integer.MAX_VALUE;

        if (dp[currDifficultyIdx][daysLeft] != -1)
            return dp[currDifficultyIdx][daysLeft];

        int currDifficulty = jobDifficulty[currDifficultyIdx];
        int ans = Integer.MAX_VALUE;

        for (int schedule = currDifficultyIdx; schedule < jobDifficulty.length; schedule++) {
            currDifficulty = Math.max(currDifficulty, jobDifficulty[schedule]);

            int nextDifficulty = dfs(daysLeft - 1, schedule + 1, jobDifficulty, dp);

            if (nextDifficulty != Integer.MAX_VALUE)
                ans = Math.min(ans, nextDifficulty + currDifficulty);
        }

        return dp[currDifficultyIdx][daysLeft] = ans;
    }
}