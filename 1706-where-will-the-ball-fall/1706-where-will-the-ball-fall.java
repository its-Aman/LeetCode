class Solution {
    int[] ans;

    public int[] findBall(int[][] grid) {
        int C = grid[0].length;

        ans = new int[C];

        for (int i = 0; i < C; i++) {
            ans[i] = -1;
            dfs(grid, 0, i, i);
        }

        return ans;
    }

    private void dfs(int[][] grid, int r, int c, int idx) {
        // System.out.println("idx: " + idx + "\tr: " + r + "\tc: " + c);
        if (r == grid.length) {
            ans[idx] = c;
            return;
        }

        if (grid[r][c] == -1 && c - 1 >= 0 && grid[r][c - 1] == -1)
            dfs(grid, r + 1, c - 1, idx);

        if (grid[r][c] == 1 && c + 1 < grid[0].length && grid[r][c + 1] == 1)
            dfs(grid, r + 1, c + 1, idx);
    }
}