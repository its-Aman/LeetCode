class Solution {
    public boolean isUgly(int n) {
        if(n <= 0)
            return false;
        
        return 1 == helper(helper(helper(n, 2), 3), 5);
    }
    
    private int helper(int x, int y) {
        while(x % y == 0)
            x /= y;
        return x;
    }
}