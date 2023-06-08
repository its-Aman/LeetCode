class Solution {
    public int countNegatives(int[][] grid) {
        int C = grid[0].length, idx = C-1, ans = 0;
        
        for(var row : grid) {
            while(idx>=0 && row[idx]<0) idx--;
            ans += (C-idx-1);
        }

        return ans;
    }
    
}