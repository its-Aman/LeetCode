class Solution {
    int MOD = (int)1e9+7;
    int[][] dirs = {{0,1}, {0, -1}, {1,0}, {-1,0}};
    int[][] dp;
    int R, C;

    public int countPaths(int[][] grid) {
        int ans = 0;
        R=grid.length;
        C=grid[0].length;
        dp = new int[R][C];

        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                ans = (ans + dfs(grid, r, c))%MOD;
            }
        }
        
        return ans;
    }
    
    private int dfs(int[][] grid, int r, int c) {
        if(dp[r][c]!=0) return dp[r][c];
        
        int ans = 1;

        for(var dir: dirs) {
            int _r = r+dir[0], _c=c+dir[1];
            if(_r>=0 && _r<R && _c>=0 && _c<C && grid[_r][_c] > grid[r][c]) {
                ans += dfs(grid, _r, _c);
                ans %= MOD;
            }
        }

        return dp[r][c]=ans;
    }

    
    public int countPaths2(int[][] grid) {
        int ans = 0;
        int MOD = (int)1e9+7;
        int R=grid.length, C=grid[0].length;
        int[][] dirs = {{0,1}, {0, -1}, {1,0}, {-1,0}};
        int[][] dp = new int[R][C];
        int[][] cellList = new int[R*C][2];
        
        for(int[] _dp: dp) Arrays.fill(_dp, 1);

        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                int idx = r*C+c;
                cellList[idx] = new int[]{r, c};
            }
        }
        
        Arrays.sort(cellList, (a, b) -> grid[a[0]][a[1]]-grid[b[0]][b[1]]);
        
        for(var cell: cellList) {
            int r=cell[0], c=cell[1];
            for(var dir: dirs) {
                int _r = r+dir[0], _c=c+dir[1];
                if(_r>=0 && _r<R && _c>=0 && _c<C && grid[_r][_c] > grid[r][c]) {
                    dp[_r][_c] += dp[r][c];
                    dp[_r][_c] %= MOD;
                }
            }
        }
        
        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                ans += dp[r][c];
                ans %= MOD;
            }
        }
        
        return ans;
    }
}