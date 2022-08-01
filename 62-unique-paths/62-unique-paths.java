class Solution {
    public int uniquePaths(int M, int N) {
        int[][] memo = new int[M][N];
        
        return this.bfs(M, N, 0, 0, memo);
    }
    
    public int bfs(int M, int N, int i, int j, int[][] memo) {
        
        if(i >= M || j >= N) {
            return 0;
        }
        
        if(memo[i][j] > 0) {
            return memo[i][j];
        }
        
        if(i == M - 1 && j == N - 1) {
            return 1;            
        }
        
        memo[i][j] = this.bfs(M, N, i + 1, j, memo) + this.bfs(M, N, i, j + 1, memo);
        return memo[i][j];
    }
}