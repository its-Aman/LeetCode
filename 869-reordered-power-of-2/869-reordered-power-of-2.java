class Solution {
    public boolean reorderedPowerOf2(int N) {
        long res = countDigits(N);
        
        for(int i = 0; i < 32; i++)
            if(this.countDigits(1 << i) == res)
                return true;

        return false;
    }
    
    private long countDigits(int N) {
        long res = 0;
        
        while(N > 0) {
            res += Math.pow(10, N % 10);
            N /= 10;
        }

        return res;
    }
}