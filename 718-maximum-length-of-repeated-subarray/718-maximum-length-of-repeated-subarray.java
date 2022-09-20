class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int x = i, y = j;

                while (x < nums1.length && y < nums2.length && nums1[x] == nums2[y]) {
                    x++;
                    y++;
                }

                ans = Math.max(ans, x - i);
            }
        }

        return ans;
    }
}