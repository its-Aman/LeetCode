class Solution {    
    public int minCapability(int[] nums, int K) {
        int l = 0, r = 1000000007;
        
        while(l < r) {
            int m = l + (r-l)/2;
            
            if(isPossible(m, nums, K)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    private boolean isPossible(int maxMoney, int[] nums, int K) {
        int N = nums.length;
        int idx = -2;
        
        for(int i = 0; i < N; i++) {
            if(nums[i] > maxMoney || idx == i - 1) {
                continue;
            }
            
            K -= 1;
            idx = i;
        }
        
        return K <= 0;
    }
}