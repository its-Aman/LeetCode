class Solution {
    int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int R, C;
    
    public boolean exist(char[][] board, String word) {
        R = board.length;
        C = board[0].length;
        
        int[] freqB = new int['z' - 'A' + 1],
                freqW = new int['z' - 'A' + 1];
        
        for(char c: word.toCharArray())
            freqW[c-'A']++;

        for(int r = 0; r < R; r++) 
            for(int c = 0; c < C; c++) 
                freqB[board[r][c]-'A']++;

        for(char c: word.toCharArray())
            if(freqB[c - 'A'] < freqW[c-'A'])
                return false;
        
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(board[r][c] == word.charAt(0)) {
                    char temp = board[r][c];
                    board[r][c] = '.';
                    if(isPresent(board, word, r, c, 1))
                        return true;
                    board[r][c] = temp;
                }
            }
        }
        
        return false;
    }
        
    private boolean isPresent(char[][] board, String word, int r, int c, int idx) {
        if(idx == word.length())
            return true;
        
        for(int[] dir: dirs) {
            int nr = r + dir[0],
                nc = c + dir[1];
            
            if(nr >= 0 && nr < R && nc >= 0 && nc < C && board[nr][nc] == word.charAt(idx)) {
                char temp = board[nr][nc];
                board[nr][nc] = '.';
                if(isPresent(board, word, nr, nc, idx + 1))
                    return true;
                board[nr][nc] = temp;
            }
        }
        
        return false;
    }
}