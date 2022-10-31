class Solution {
    public boolean isToeplitzMatrix(int[][] M) {
        int R = M.length, 
            C = M[0].length;
        
        for(int r = 1; r < R; r++)
            for(int c = 1; c < C; c++)
                if(M[r][c] != M[r-1][c-1])
                    return false;
        
        return true;
    }
}