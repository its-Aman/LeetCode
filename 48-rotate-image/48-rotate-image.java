class Solution {
    public void rotate_2(int[][] M) {
        int N = M.length;
        int i = 0, j = N - 1;
        
        while(i < j) {
            
            for(int k = 0; k < (j - i); k++) {
                swap(M, i, i + k, i + k, j);
                swap(M, i, i + k, j, j - k);
                swap(M, i, i + k, j - k, i);
            }
            
            ++i;
            --j;
        }
    }
    
    private void swap(int[][] M, int x1, int y1, int x2, int y2) {
        int temp = M[x1][y1];
        M[x1][y1] = M[x2][y2];
        M[x2][y2] = temp;
    }
    
    public void rotate(int[][] M) {
        int N = M.length;
        
        for(int r = 0; r < (N + 1) / 2; r++) {
            
            for(int c = 0; c < N / 2; c++) {
                
                int temp = M[r][c];
                M[r][c] = M[N - 1 - c][r];
                M[N - 1 - c][r] = M[N - 1 - r][N - 1 - c];
                M[N - 1 - r][N - 1 - c] = M[c][N - 1 - r];
                M[c][N - 1 - r] = temp;

            }
            
        }
        
    }
}