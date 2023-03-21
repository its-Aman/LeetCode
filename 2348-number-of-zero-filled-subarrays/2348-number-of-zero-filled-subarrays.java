class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int N = nums.length, zero = 0;

        for(int i = 0; i < N; i++) {
            if(nums[i] == 0) {
                zero++;
                ans += zero;
            } else {
                zero = 0;
            }
        }
        
        
        return ans;
    }
}