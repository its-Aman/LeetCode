class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long ln = (long)n;
        
        if(n == 0)
            return ans;

        // if(n == Integer.MIN_VALUE)
        //     return 1/x * myPow(x, -Integer.MAX_VALUE);
        
        if(ln < 0) {
            x = 1/x;
            ln = -ln;
        }
        
        while(ln > 0) {
            if((ln & 1) == 1) 
                ans *= x;

            x *= x;
            ln >>= 1;                
        }
        
        return ans;
    }
}