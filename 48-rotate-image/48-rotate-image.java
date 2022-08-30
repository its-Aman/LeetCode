class Solution {
    public void rotate(int[][] M) {
        this.transpose(M);
        this.reflect(M);
    }
    
    private void transpose(int[][] M) {
        int N = M.length;
        
        for(int r = 0; r < N; r++) {
            for(int c = r + 1; c < N; c++){
                int temp = M[r][c];
                M[r][c] = M[c][r];
                M[c][r] = temp;
            }
        }
    }
    
    private void reflect(int[][] M) {
        int N = M.length;
        
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N / 2; c++) {
                int temp = M[r][c];
                M[r][c] = M[r][N - 1 - c];
                M[r][N - 1 - c] = temp;
            }
        }
    }
}