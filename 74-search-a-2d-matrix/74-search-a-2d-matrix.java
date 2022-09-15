class Solution {
    public boolean searchMatrix(int[][] M, int k) {
        int R = M.length, C = M[0].length;
        int r = 0, c = C - 1;
        
        while(r < R && c >= 0 && c < C) {
            if(M[r][c] == k)
                return true;
            else if(M[r][c] < k)
                r++;
            else
                c--;
        }
        
        return false;
    }
}