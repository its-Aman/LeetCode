class Solution {
    public int rob(int[] nums) {
        int N = nums.length,
            rob = 0, 
            noRob = 0;
        
        for(int num: nums) {
            int prevRob = rob;
            rob = Math.max(rob, num + noRob);
            noRob = prevRob;
        }
        
        return rob;
    }
}