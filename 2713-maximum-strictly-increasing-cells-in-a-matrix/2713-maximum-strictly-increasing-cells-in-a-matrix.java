class Solution {
    public int maxIncreasingCells(int[][] mat) {
        int R = mat.length, C = mat[0].length;
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        int[][] dp = new int[R][C];
        int[] res = new int[R + C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                map.computeIfAbsent(mat[r][c], k -> new ArrayList<>()).add(new int[]{r, c});
            }
        }

        for (int key : map.keySet()) {
            for (int[] pos : map.get(key)) {
                int r = pos[0], c = pos[1];
                dp[r][c] = Math.max(res[r], res[R + c]) + 1;
            }

            for (int[] pos : map.get(key)) {
                int r = pos[0], c = pos[1];
                res[R + c] = Math.max(res[R + c], dp[r][c]);
                res[r] = Math.max(res[r], dp[r][c]);
                dp[r][c] = Math.max(res[r], res[r + c]) + 1;
            }
        }
        
        return Arrays.stream(res).max().getAsInt();
    }
}