class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int N = nums.length;
        int currMax = 0, maxSum = nums[0],
            currMin = 0, minSum = nums[0],
            total = 0;
        
        for(int i = 0; i < N; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSum = Math.max(currMax, maxSum);

            currMin = Math.min(nums[i], currMin + nums[i]);
            minSum = Math.min(currMin, minSum);
            
            total += nums[i];
        }
        
        if(maxSum > 0) {
            return Math.max(total - minSum, maxSum);
        } else {
            return maxSum;
        }
    }
}