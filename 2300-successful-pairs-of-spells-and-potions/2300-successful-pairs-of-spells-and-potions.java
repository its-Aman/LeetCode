class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int N = spells.length,
            M = potions.length;
        int[] ans = new int[N];
        
        Arrays.sort(potions);
        
        for(int i = 0; i < N; i++) {
            ans[i] = binarySearch(potions, spells[i], success);
        }
        
        return ans;
    }
    
    private int binarySearch(int[] arr, int x, long k) {
        int N = arr.length;
        int l = 0, h = N - 1;
        
        while(l <= h) {
            int m = l + ((h - l) / 2);
            
            if(((long)arr[m] * (long)x) < k) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        
        return N - l;
    }
}