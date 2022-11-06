class Solution {
    Long dp[][];

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(f -> f[0]));

        dp = new Long[robot.size() + 1][factory.length + 1];

        return solve(robot, factory, 0, 0);
    }

    private long solve(List<Integer> robot, int[][] factory, int r, int f) {
        if (r >= robot.size())
            return 0;

        if (f >= factory.length)
            return Long.MAX_VALUE;

        if (dp[r][f] != null)
            return dp[r][f];

        long curr = 0;
        long res = solve(robot, factory, r, f + 1);

        for (int k = r; k < robot.size() && k - r + 1 <= factory[f][1]; k++) {
            curr += Math.abs(robot.get(k) - factory[f][0]);
            long next = solve(robot, factory, k + 1, f + 1);

            if (next != Long.MAX_VALUE)
                res = Math.min(res, curr + next);
        }

        return dp[r][f] = res;
    }
}