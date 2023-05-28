class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int[][] ans = new int[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                ans[r][c] = findUniq(grid, r, c);
            }
        }

        return ans;
    }

    private int findUniq(int[][] G, int R, int C) {
        Set<Integer> tl = new HashSet<>(), br = new HashSet<>();

        for (int i = 1; i <= G.length; i++) {
            // top left
            if (R - i >= 0 && C - i >= 0) {
                tl.add(G[R - i][C - i]);
            }
    
            // bottom right
            if (R + i < G.length && C + i < G[0].length) {
                br.add(G[R + i][C + i]);
            }
        }
        
        return Math.abs(tl.size() - br.size());
    }
}