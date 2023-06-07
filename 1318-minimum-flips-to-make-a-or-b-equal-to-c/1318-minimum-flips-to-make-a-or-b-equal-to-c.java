class Solution {
    public int minFlips(int a, int b, int c) {
        int crossBits = (a|b)^c;
        return Integer.bitCount(crossBits)+Integer.bitCount((a&b)&crossBits);
    }
    
    private int countBit(int x) {
        int cnt = 0;
        
        while(x > 0) {
            cnt += x&1;
            x>>=1;
        }
        
        return cnt;
    }
}