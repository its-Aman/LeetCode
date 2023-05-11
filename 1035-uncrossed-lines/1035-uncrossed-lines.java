class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1=nums1.length, n2=nums2.length;
        
        if(n1>n2) return maxUncrossedLines(nums2, nums1);

        int[] dp = new int[n2+1];
        
        for(int i=1; i<=n1; i++) {
            int prev=0, curr=0;
            
            for(int j=1; j<=n2; j++) {
                curr = dp[j];
                
                if(nums1[i-1] == nums2[j-1]) {
                    dp[j] = 1+prev;
                } else {
                    dp[j] = Math.max(dp[j], dp[j-1]);                    
                }
                
                prev = curr;
            }
        }
        
        return dp[n2];
    }
}