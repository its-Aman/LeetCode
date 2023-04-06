class Solution {
    int R, C;
    
    public int closedIsland(int[][] grid) {
        R = grid.length;
        C = grid[0].length;

        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if((r*c*(r+1-R)*(c+1-C)) == 0) {
                    fill(grid, r, c);
                }
            }        
        }
        
        int island = 0;
        
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                island += fill(grid, r, c) > 0 ? 1 : 0;
            }        
        }
        
        return island;
    }
    
    private int fill(int[][] grid, int r, int c) {
        if(r < 0 || r >= R || c < 0 || c >= C || grid[r][c] != 0) {
            return 0;
        }
        
        grid[r][c] = 1;

        return (
            1 +
            fill(grid, r+1,c) +
            fill(grid, r-1,c) +
            fill(grid, r,c+1) +
            fill(grid, r,c-1)
        );
    }
}

class Solution2 {
    int R, C;
    
    public int closedIsland(int[][] grid) {
        R = grid.length;
        C = grid[0].length;
        
        for(int r = 0; r < R; r++) {
            dfs(grid, r, 0);
            dfs(grid, r, C-1);
        }
        
        for(int c = 0; c < C; c++) {
            dfs(grid, 0, c);
            dfs(grid, R-1, c);
        }
        
        int island = 0;
        
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(grid[r][c] == 0) {
                    island++;
                    dfs(grid, r, c);
                }
            }        
        }

        return island;
    }
    
    private void dfs(int[][] grid, int r, int c) {
        if(r < 0 || r >= R || c < 0 || c >= C || grid[r][c] != 0) {
            return;
        }
        
        grid[r][c] = -1;
        
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
}