class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        int R = grid.length, C = grid[0].length;

        int M = findNumberOfPaths(grid, R - 1, C - 1);

        grid[R - 1][C - 1] = 1;

        int N = findNumberOfPaths(grid, R - 1, C - 1);

        return N >= 1 ? false : true;
    }

    private int findNumberOfPaths(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || grid[i][j] == 0) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return 1;
        }

        grid[i][j] = 0;

        if (findNumberOfPaths(grid, i - 1, j) == 1) {
            return 1;
        }
        
        return findNumberOfPaths(grid, i, j - 1);
    }
}