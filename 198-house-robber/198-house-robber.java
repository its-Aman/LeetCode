class Solution {
    public int rob(int[] nums) {
        int N = nums.length;        
        int rob = 0;
        int noRob = 0;
        
        for(int i = 0; i < N; i++) {
            int prevLoot = rob;
            rob = Math.max(rob, nums[i] + noRob);
            noRob = prevLoot;
        }
        
        return rob;
    }
}