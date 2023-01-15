class Solution {
    public int[][] rangeAddQueries(int N, int[][] queries) {
        int[][] ans = new int[N][N];

        for (var q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];

            for (int r = r1; r <= r2; r++) {
                ans[r][c1]++;

                if (c2 + 1 < N) {
                    ans[r][c2 + 1]--;
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 1; c < N; c++) {
                ans[r][c] += ans[r][c - 1];
            }
        }

        return ans;
    }
}