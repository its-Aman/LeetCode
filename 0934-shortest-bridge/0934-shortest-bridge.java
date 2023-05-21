class Solution {
    public int shortestBridge(int[][] grid) {
        int N = grid.length;
        int firstX = -1, firstY = -1;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    firstX = r;
                    firstY = c;
                    break;
                }
            }
        }

        List<int[]> bfsQueue = new ArrayList<>(), secondBfsQueue = new ArrayList<>();

        bfsQueue.add(new int[]{firstX, firstY});
        secondBfsQueue.add(new int[]{firstX, firstY});
        grid[firstX][firstY] = 2;

        while (!bfsQueue.isEmpty()) {
            List<int[]> newBfs = new ArrayList<>();
            for (var cell : bfsQueue) {
                for (var dir : dirs) {
                    int xx = cell[0] + dir[0], yy = cell[1] + dir[1];

                    if (xx >= 0 && xx < N && yy >= 0 && yy < N && grid[xx][yy] == 1) {
                        newBfs.add(new int[]{xx, yy});
                        secondBfsQueue.add(new int[]{xx, yy});
                        grid[xx][yy] = 2;
                    }
                }
            }
            bfsQueue = newBfs;
        }

        int ans = 0;

        while (!secondBfsQueue.isEmpty()) {
            List<int[]> newBfs = new ArrayList<>();
            for (var cell : secondBfsQueue) {
                for (var dir : dirs) {
                    int xx = cell[0] + dir[0], yy = cell[1] + dir[1];

                    if (xx >= 0 && xx < N && yy >= 0 && yy < N) {
                        if (grid[xx][yy] == 1) {
                            return ans;
                        } else if (grid[xx][yy] == 0) {
                            newBfs.add(new int[]{xx, yy});
                            grid[xx][yy] = -1;
                        }
                    }
                }
            }
            secondBfsQueue = newBfs;
            ans++;
        }

        return ans;
    }
}