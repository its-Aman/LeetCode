class Solution {
    public int maxProduct(int[] nums) {
        int N = nums.length;
        int ans = nums[0], max = ans, min = ans;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < 0) {
                max = max ^ min;
                min = max ^ min;
                max = max ^ min;
            }
            
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            
            ans = Math.max(ans, max);
        }
        
        return ans;
    }
}