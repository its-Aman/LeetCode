class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        long ans = 0;

        boolean[][] seen = new boolean[2][n];
        int[] cnts = new int[]{n, n};

        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0], index = queries[i][1], val = queries[i][2];
            if (!seen[type][index]) {
                seen[type][index] = true;
                cnts[type]--;
                ans += (long) cnts[1 - type] * val;
            }
        }

        return ans;
    }

    public long matrixSumQueries2(int n, int[][] queries) {
        long ans = 0;

        boolean[] rows = new boolean[n], cols = new boolean[n];
        int rowCnts = n, colCnts = n;

        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0], index = queries[i][1], val = queries[i][2];
            if (type == 0 && !rows[index]) {
                rows[index] = true;
                rowCnts--;
                ans += (long) colCnts * val;
            }
            if (type == 1 && !cols[index]) {
                cols[index] = true;
                colCnts--;
                ans += (long) rowCnts * val;
            }
        }

        return ans;
    }
}