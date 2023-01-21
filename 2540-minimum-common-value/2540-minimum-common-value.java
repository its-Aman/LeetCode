class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int N1 = nums1.length, N2 = nums2.length;
        
        for (int i = 0, j = 0; i < N1 && j < N2; ) {
            if(nums1[i] == nums2[j]) {
                return nums1[i];
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return -1;
    }

}