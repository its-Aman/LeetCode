class Solution {
    public int longestSubarray(int[] nums) {
        int N = nums.length;
        int ans=0, j=0, lastZero=-1;
        
        for(int i=0; i<N; i++) {
            if(nums[i]==0) {
                j=lastZero+1;
                lastZero=i;
            }
            
            ans = Math.max(ans, i-j);
        }
    
        return ans;
    }    
    
    public int longestSubarray2(int[] nums) {
        int N = nums.length, ans = 0;
        int j=0, zeroCnt=0;
        
        for(int i=0; i<N; i++) {
            zeroCnt += 1-nums[i];
            
            while(zeroCnt > 1) zeroCnt -= 1-nums[j++];

            ans = Math.max(ans, i-j);
        }
    
        return ans;
    }
}