class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int l = 0, r = 0;
        
        for(int w: weights) {
            l = Math.max(l, w);
            r += w;
        }
        
        while(l < r) {
            int cap = l + ((r - l) >> 1);
            if(withCap(cap, D, weights)) {
                r = cap;
            } else {
                l = cap + 1;
            }
        }
        
        return l;
    }
    
    private boolean withCap(int c, int D, int[] weights) {
        int N = weights.length;
        int init = 0;
        
        for(int w: weights) {
            if(init + w <= c) {
                init += w;
            } else {
                init = w;
                D -= 1;
            }
            
            if(w > c || D < 0) {
                return false;
            }
        }
        
        return (D > 0);
    }
}