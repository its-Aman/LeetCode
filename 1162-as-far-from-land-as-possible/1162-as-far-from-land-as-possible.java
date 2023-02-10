class Solution {

    public int maxDistance(int[][] grid) {
        int N = grid.length,
            dist = -1;
        
        Queue<int[]> q = new LinkedList<>();
        
        int[][] vis = new int[N][N],
                dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
        
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                vis[r][c] = grid[r][c];
                if(vis[r][c] == 1) {
                    q.offer(new int[] {r, c});
                }
            }
        }
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            while(size-- > 0) {
                var curr = q.poll();
                
                for(int[] dir: dirs) {
                    int r = curr[0] + dir[0], c = curr[1] + dir[1];
                    
                    if(r >= 0 && r < N && c >= 0 && c < N && vis[r][c] == 0) {
                        vis[r][c] = 1;
                        q.offer(new int[] {r, c});
                    }
                }
            }
            
            dist++;
        }

        if(dist == 0) {
            dist = -1;
        }
        
        return dist;
    }
}