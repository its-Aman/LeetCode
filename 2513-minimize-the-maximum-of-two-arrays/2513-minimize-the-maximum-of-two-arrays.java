class Solution {
    public int minimizeSet(int d1, int d2, int c1, int c2) {
        long l = 1, r = (long)2e9;
        
        while(l < r) {
            long m = (l+r) >> 1;
            
            if(isPossible(m, d1, d2, c1, c2)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return (int)l;
    }
    
    private boolean isPossible(long max, int d1, int d2, int c1, int c2) {
        long valid = max;
        
        long bothInvalid = max / lcm(d1, d2);
        long arr1Invalid = max / d1 - bothInvalid;
        long arr2Invalid = max / d2 - bothInvalid;
        
        long canBeInAny = max - arr1Invalid - arr2Invalid - bothInvalid;
        
        if(arr2Invalid < c1) {
            canBeInAny -= (c1 - arr2Invalid);
        }

        if(arr1Invalid < c2) {
            canBeInAny -= (c2 - arr1Invalid);
        }
        
        return (canBeInAny >= 0);
    }
    
    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
    
    private long gcd(long a, long b) {
        if(b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
}