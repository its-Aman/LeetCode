class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        
        if(n == 0)
            return ans;

        if(n == Integer.MIN_VALUE)
            return 1/x * myPow(x, -Integer.MAX_VALUE);
        
        if(n < 0) {
            x = 1/x;
            n = -n;
        }
        
        while(n > 0) {
            if((n & 1) == 1) 
                ans *= x;

            x *= x;
            n >>= 1;                
        }
        
        return ans;
    }
}