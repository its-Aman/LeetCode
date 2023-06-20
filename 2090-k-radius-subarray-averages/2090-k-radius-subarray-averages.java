class Solution {
    public int[] getAverages(int[] nums, int k) {
        int N = nums.length;
        int[] ans = new int[N];
        
        Arrays.fill(ans, -1);
        
        if(k+k+1>N) return ans;
        
        double sum=0;

        for(int i=0; i<k+k+1; i++) sum += nums[i];
        
        double avg = sum/(k+k+1);
        ans[k] = (int)avg;

        for(int i=k+k+1, c=0; i<N; i++, c++) {
            sum += nums[i];
            sum -= nums[c];

            avg = sum/(k+k+1);
            ans[k+c+1] = (int)avg;
        }
        
        return ans;
    }
}