class Solution {
    public int minimumAverageDifference(int[] nums) {
        int N = nums.length,
            idx = -1;
        long leftSum = 0, rightSum = 0,
            minSum = Long.MAX_VALUE;
        
        for(int num: nums)
            rightSum += num;
        
        for(int i = 0; i < N; i++){
            leftSum += nums[i];
            rightSum -= nums[i];
            int l = i + 1, r = N - i - 1;
            int avg = (int) Math.abs((leftSum / l) - (rightSum / (r == 0 ? 1 : r)));
            
            if(avg < minSum) {
                minSum = avg;
                idx = i;
            }
        }
        
        return idx;
    }
}