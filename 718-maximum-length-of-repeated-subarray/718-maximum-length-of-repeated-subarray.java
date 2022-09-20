class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int N1 = nums1.length, N2 = nums2.length, ans = 0;
        int[][] dp = new int[N1 + 1][N2 + 1];

        for (int i = N1 - 1; i >= 0; i--) {
            for (int j = N2 - 1; j >= 0; j--) {
                if(nums1[i] == nums2[j])
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }
}