class Solution {
    public long minimumReplacement(int[] nums) {
        long ans = 0;
        int N = nums.length;
        
        for(int i = N - 2, prev = nums[N - 1]; i >= 0; i--) {
            int noOfTimes = nums[i] / prev;

            if(nums[i] % prev != 0) {
                noOfTimes += 1;
                prev = nums[i] / noOfTimes;
            }
            
            ans += noOfTimes - 1;
        }
        
        return ans;
    }
}