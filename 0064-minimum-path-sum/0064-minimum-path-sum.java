class Solution {
    public int minPathSum(int[][] grid) {
        int R = grid.length, 
            C = grid[0].length;
        
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(r == 0 && c == 0) {
                    continue;
                }

                if(r == 0) {
                    grid[r][c] += grid[r][c-1];
                } else if(c == 0) {
                    grid[r][c] += grid[r-1][c];
                } else {
                    grid[r][c] += Math.min(grid[r][c-1], grid[r-1][c]);
                }
            }
        }
        
        return grid[R-1][C-1];
    }
    
    
    public int minPathSum2(int[][] grid) {
        int R = grid.length, 
            C = grid[0].length;

        return minPathSum2(grid, R - 1, C - 1);
    }
    
    private int minPathSum2(int[][] grid, int r, int c) {
        if(r == 0 && c == 0) {
            return grid[r][c];
        }
        
        if(r == 0) {
            return grid[r][c] + minPathSum2(grid, r, c - 1);
        }

        if(c == 0) {
            return grid[r][c] + minPathSum2(grid, r - 1, c);
        }
        
        return grid[r][c] + Math.min(minPathSum2(grid, r, c - 1), minPathSum2(grid, r - 1, c));
    }
}