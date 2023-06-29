class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int R = grid.length, C = grid[0].length();
        int startRow = 0, startCol = 0, allKeys = 0;
        boolean[][][] visited = new boolean[R][C][64];
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startRow = i;
                    startCol = j;
                }

                if (c >= 'a' && c <= 'f') allKeys = (allKeys << 1) + 1;
            }
        }

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startRow, startCol, 0, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0], col = curr[1], distance = curr[2], keys = curr[3];

            char c = grid[row].charAt(col);

            if (c >= 'a' && c <= 'f') keys |= (1 << (c - 'a'));

            if (visited[row][col][keys]) continue;

            visited[row][col][keys] = true;

            if (keys == allKeys) return distance;

            for (int[] dir : dirs) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (nextRow >= R || nextCol >= C || nextRow < 0 || nextCol < 0 || grid[nextRow].charAt(nextCol) == '#' || visited[nextRow][nextCol][keys])
                    continue;

                char nextChar = grid[nextRow].charAt(nextCol);

                if (nextChar >= 'A' && nextChar <= 'F') {
                    int lock = 1 << (nextChar - 'A');
                    if ((keys & lock) == 0) continue;
                }

                q.offer(new int[]{nextRow, nextCol, distance + 1, keys});
            }
        }

        return -1;
    }
    
    public int shortestPathAllKeys2(String[] grid) {
        int x=-1, y=-1, keyCount = 0;
        int R = grid.length, C = grid[0].length();
        int[][] dirs = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
        boolean[] keyAndLock = new boolean[26];
            
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length(); j++) {
                if(grid[i].charAt(j) == '@') {
                    x=i; y=j;
                }

                if(Character.isLowerCase(grid[i].charAt(j))) keyCount++;
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> -a[2]));
        q.offer(new int[]{x, y, 0});
        
        while(!q.isEmpty()) {
            var curr = q.poll();
            
            for(var dir: dirs) {
                int xx = curr[0]+dir[0], yy = curr[1]+dir[1], dist=curr[2];
                
                if(xx < 0 || yy < 0 || xx >= R || yy >= C || grid[xx].charAt(yy) == '#') continue;
                
                char c = grid[xx].charAt(yy);
                
                if(Character.isUpperCase(c) && !keyAndLock[c-'A']) continue;
                
                if(Character.isLowerCase(c)) {
                    keyAndLock[c-'a'] = true;
                    keyCount--;
                }
                
                if(keyCount <= 0) return dist;

                q.offer(new int[] {xx, yy, dist+1});
                
            }
        }

        return -1;
    }
}