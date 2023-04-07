class Solution {
    int R, C;
    
    public int numEnclaves(int[][] grid) {
        R = grid.length;
        C = grid[0].length;
        
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(r*c*(r+1-R)*(c+1-C) == 0) {
                    fill(grid, r, c);
                }
            }
        }
        
        int ans = 0;
        
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                ans += grid[r][c];
            }
        }
        
        return ans;
    }
    
    private void fill(int[][] grid, int r, int c) {
        if(r < 0 || r >= R || c < 0 || c >= C || grid[r][c] != 1) {
            return;
        }
        
        grid[r][c] = 0;
        
        fill(grid, r+1, c);
        fill(grid, r-1, c);
        fill(grid, r, c+1);
        fill(grid, r, c-1);
    }
}