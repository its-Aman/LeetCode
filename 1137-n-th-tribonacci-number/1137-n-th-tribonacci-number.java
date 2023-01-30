class Solution {
    
    public int tribonacci(int n) {
        int t0 = 0, t1 = 1, t2 = 1;

        if(n == 0) {
            return t0;
        } else if(n < 3) {
            return t1;
        }
        
        
        for(int i = 3; i <= n; i++) {
            int tn = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = tn;
        }

        return t2;
    }
}