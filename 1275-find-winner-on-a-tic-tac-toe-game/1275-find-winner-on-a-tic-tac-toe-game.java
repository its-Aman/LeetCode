class Solution {
    public String tictactoe(int[][] moves) {
        int[][] grid = new int[3][3];
        
        for(int i = 0; i < moves.length; i++)
            grid[moves[i][0]][moves[i][1]] = i % 2 == 0 ? 1 : -1;
        
        if(check(grid, 3) != null)
            return check(grid, 3);
        
        if(moves.length == 9)
            return "Draw";

        return "Pending";
        
    }

    private String check(int[][] grid, int N) {
        int A = 0, rA = 0;
        int B = 0, rB = 0;
        
        for(int i = 0; i < N; i++) {
            if(grid[i][i] == 1) ++A;
            if(grid[i][i] == -1) ++B;
            
            if(grid[i][N - 1 - i] == 1) ++rA;
            if(grid[i][N - 1 - i] == -1) ++rB;
        }
        
        if(A == N || rA == N) return "A";
        if(B == N || rB == N) return "B";
        
        for(int i = 0; i < N; i++) {
            A = 0;
            rA = 0;
            B = 0;
            rB = 0;
            for(int j = 0; j < N; j++) {
                if(grid[i][j] == 1) ++A;
                if(grid[i][j] == -1) ++B;

                if(grid[j][i] == 1) ++rA;
                if(grid[j][i] == -1) ++rB;
            }

            if(A == N || rA == N) return "A";
            if(B == N || rB == N) return "B";
        }
        
        return null;
    }
}