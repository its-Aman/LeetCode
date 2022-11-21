class Solution {
    
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirs = new int[][] {{-1,0}, {0,1}, {1,0},{0,-1}};
        int R = maze.length, C = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        maze[entrance[0]][entrance[1]] = '+';
        q.offer(new int[] {entrance[0], entrance[1], 0});
        
        while(!q.isEmpty()) {
            var curr = q.poll();
            int r = curr[0], c = curr[1], currDist = 1 + curr[2];

            for(int[] dir: dirs) {
                int x = dir[0] + r,
                    y = dir[1] + c;

                if(x >= 0 && x < R && y >= 0 && y < C && maze[x][y] == '.') {

                    if(x == 0 || y == 0 || x == R - 1 || y == C - 1) 
                        return currDist;

                    maze[x][y] = '+';
                    q.offer(new int[] {x, y, currDist});
                }
            }
        }
        
        return -1;
    }
}