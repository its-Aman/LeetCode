class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int N1 = nums1.length, N2 = nums2.length, ans = 0;
        
        if(N2 > N1)
            return findLength(nums2, nums1);
        
        int[][] dp = new int[2][N1 + 1];

        for (int i = N1 - 1, curr = i & 1, next = (curr + 1) % 2; i >= 0; i--, curr ^= 1, next ^= 1) {
            for (int j = N2 - 1; j >= 0; j--) {
                dp[curr][j] = nums1[i] == nums2[j] ? dp[next][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[curr][j]);
            }
        }

        return ans;
    }
}