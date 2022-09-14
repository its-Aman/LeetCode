class Solution {
    public int maximalSquare(char[][] M) {
        int R = M.length, C = M[0].length;
        int ans = Integer.MIN_VALUE;
        
        int prev = 0;
        int[] dp = new int[C + 1];
            
        for(int r = 1; r <= R; r++) {
            
            for(int c = 1; c <= C; c++) {
                int temp = dp[c];
                
                if(M[r - 1][c - 1] == '1') {
                    dp[c] = Math.min(dp[c], Math.min(dp[c - 1], prev)) + 1;
                    ans = Math.max(ans, dp[c]);
                } else {
                    dp[c] = 0;
                }
                prev = temp;
            }
            
        }
        
        return ans * ans;
    }
}