/*
[
    ["1","1","1"],
    ["0","1","0"],
    ["1","1","1"]
]
*/
class Solution {
    public int numIslands(char[][] grid) {
        int R = grid.length, C = grid[0].length;
        int ans = 0;

        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(grid[r][c] == '1') {
                    ans += 1;
                    grid[r][c] = '0';
                    this.dfs(grid, r, c);
                }
            }
        }
        
        return ans;
    }
    
    private void dfs(char[][] G, int r, int c) {
        
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        
        for(int d = 3; d >= 0; d--) {
            int dr = r + dirs[d], dc = c + dirs[d + 1];
            
            if(dr >= 0 && dr < G.length && dc >= 0 &&  dc < G[0].length && G[dr][dc] == '1') {
                G[dr][dc] = '0';
                this.dfs(G, dr, dc);
            }
        }
    }
}