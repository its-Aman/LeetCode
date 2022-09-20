class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        return findLength_Sliding_Window(nums1, nums2);
    }

    public int findLength_Sliding_Window(int[] nums1, int[] nums2) {
        int N1 = nums1.length, N2 = nums2.length, ans = 0;

        for (int i = 0; i < N1 + N2 - 1; i++) {
            int x = Math.max(0, (N1 - 1) - i);
            int y = Math.max(0, i - (N1 - 1));
            int score = 0;

            for (int xx = x, yy = y; xx < N1 && yy < N2; ++xx, ++yy) {
                if (nums1[xx] == nums2[yy])
                    ++score;
                else
                    score = 0;

                ans = Math.max(ans, score);
            }
        }

        return ans;
    }

    public int findLength_DP(int[] nums1, int[] nums2) {
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