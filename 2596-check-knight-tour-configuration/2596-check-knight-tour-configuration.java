class Solution {
    public boolean checkValidGrid(int[][] grid) {
        
        if(grid[0][0] != 0) {
            return false;
        }
        
        int N = grid.length, cnt = 0, total = (N * N) - 1;
        int r = 0, c = 0;
        int[][] ptr = new int[N * N][2];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                ptr[grid[i][j]] = new int[] {i, j};
            }
        }
        
        for(int i = 1; i < N * N; i++) {
            int dx = Math.abs(ptr[i][0] - ptr[i-1][0]);
            int dy = Math.abs(ptr[i][1] - ptr[i-1][1]);

            if(dx < 1 || dx > 2 || dy < 1 || dy > 2) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean checkValidGrid2(int[][] grid) {
        int N = grid.length, cnt = 0, total = (N * N) - 1;
        int r = 0, c = 0;
        int[][] next = new int[][]{
                {-2, 1},
                {-2, -1},
                {2, 1},
                {2, -1},
                {1, -2},
                {-1, -2},
                {1, 2},
                {-1, 2},
        };

        boolean isValid = true;

        while (isValid) {
            isValid = false;
            for (var nn : next) {
                // System.out.printf("%d\t%d\t%d\n", grid[r][c],r, c);
                int rr = r + nn[0], cc = c + nn[1];

                if (rr < 0 || rr >= N || cc < 0 || cc >= N) {
                    continue;
                }

                if (grid[rr][cc] == cnt + 1) {
                    isValid = true;
                    r = rr;
                    c = cc;
                    cnt++;
                    break;
                }
            }
        }

        return cnt == total;
    }
}