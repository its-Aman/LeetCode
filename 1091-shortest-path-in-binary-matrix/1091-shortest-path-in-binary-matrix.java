class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        
        if((grid[0][0] | grid[R-1][C-1]) == 1) return -1;

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};

        q.offer(new int[]{0, 0, 1});
        grid[0][0] = 1;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            while(size-- > 0) {
                var curr = q.poll();
                int x = curr[0], y = curr[1], dist = curr[2];
                
                if(x+1 == R && y+1 == C) return dist;
                
                for(int[] dir: dirs) {
                    int xx = x + dir[0];
                    int yy = y + dir[1];
                    
                    
                    if(xx >= 0 && yy >= 0 && xx < R && yy < C && grid[xx][yy] == 0) {
                        grid[xx][yy] = 1;
                        q.offer(new int[]{xx, yy, dist+1});
                    }
                }
            }
        }
        
        return -1;
    }
}