class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        if(N == 1) return nums[0];
        
        return Math.max(rob(nums, 0, N-1), rob(nums, 1, N));
    }
    
    public int rob(int[] nums, int start, int end) {
        int rob = 0, noRob = 0;
        
        for(int i = start; i < end; i++) {
            int prevRob = rob;
            rob = Math.max(rob, nums[i] + noRob);
            noRob = prevRob;
        }
        
        return rob;
    }
}