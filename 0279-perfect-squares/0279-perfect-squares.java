class Solution {
    
    public int numSquares(int n) {
        return numSquares_math(n);
    }
    
    // https://www.youtube.com/watch?v=1xfx6M_GqFk
    public int numSquares_math(int n) {
        if(isSquare(n))
            return 1;
        
        while((n & 3) == 0) // n%4
            n >>= 2;

        if((n & 7) == 7)  // n%8
           return 4;
           
       for(int i = 1; i*i <= n; i++)
           if(isSquare(n - i*i))
               return 2;
           
       return 3;
    }
    
    // https://www.youtube.com/watch?v=aZuQXkO0-XA
    public int numSquares_dp(int n) {
        int ans = 0;
        int[] dp = new int[n + 1];
        
        for(int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            
            for(int j = 1; j * j <= i; j++)
                dp[i] = Math.min(dp[i], 1 + dp[i - (j * j)]);
        }
        
        return dp[n];
    }
    
    private boolean isSquare(int n) {
        double x = Math.sqrt(n);
        return Math.ceil(x) == Math.floor(x);
    }
}