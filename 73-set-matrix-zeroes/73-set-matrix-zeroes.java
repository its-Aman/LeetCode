class Solution {

    public void setZeroes(int[][] M) {
        int R = M.length, C = M[0].length;
        boolean isFirstCol = false;

        for (int r = 0; r < R; r++)
            for (int c = 0; c < C; c++)
                if (M[r][c] == 0) {
                    M[r][0] = 0;
                    if (c > 0)
                        M[0][c] = 0;
                    else
                        isFirstCol = true;
                }

        for (int r = 1; r < R; r++)
            for (int c = 1; c < C; c++)
                if (M[r][0] == 0 || M[0][c] == 0)
                    M[r][c] = 0;

        if (M[0][0] == 0)
            for (int c = 0; c < C; c++)
                M[0][c] = 0;

        if (isFirstCol)
            for (int r = 0; r < R; r++)
                M[r][0] = 0;
    }
    
}