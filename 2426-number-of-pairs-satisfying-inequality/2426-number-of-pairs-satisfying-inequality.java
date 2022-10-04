class Solution {
    int[] bit;
    
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        bit = new int [60_001];    
        
        long result = 0;
        int d;
        
        for (int i = 0; i < nums1.length; ++i){
            d = nums1[i] - nums2[i];
            
            result += getBitVal(d + diff);
            addToBit(d);
        }
        
        return result;
    }
    
    private void addToBit(int val){
        val += 30_000;
        
        if (val <= 0) return;
        
        for (int i = val; i < bit.length; i += (i & -i))
            bit[i]++;
    }
    
    private int getBitVal(int val){
        val += 30_000;
        int result = 0;
        
        for (int i = val; i > 0; i -= (i & -i))
            result += bit[i];    
        
        return result;
    }
}