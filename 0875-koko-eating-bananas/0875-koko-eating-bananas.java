class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int N = piles.length,
            l = 1,
            r = Integer.MIN_VALUE;
        
        for(int pile: piles) {
            r = Math.max(r, pile);
        }
        
        while(l < r) {
            int m = l + ((r - l) / 2);
            
            if(canEatAll(piles, h, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    private boolean canEatAll(int[] piles, int h, int k) {
        for(int pile: piles) {
            h -= ((pile - 1) / k) + 1;
        }
        
        return h >= 0;
    }
}