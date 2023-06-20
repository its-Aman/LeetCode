class Solution {
    public int[] getAverages(int[] nums, int k) {
        int N = nums.length;
        int[] ans = new int[N];
        long sumL=0, sumR=0;
        
        for(int i=0; i<N; i++) {
            sumL += nums[i];

            if(i+k<N) {
                sumR += nums[i+k];
            }

            if(i-k < 0) {
                ans[i] = -1;
            } else if(i+k>=N) {
                ans[i] = -1;
            } else {
                ans[i] = (int)((sumL+sumR-nums[i])/(k+k+1));

                sumL -= nums[i-k];
                sumR -= nums[i];
            }
        }
        
        return ans;
    }
}