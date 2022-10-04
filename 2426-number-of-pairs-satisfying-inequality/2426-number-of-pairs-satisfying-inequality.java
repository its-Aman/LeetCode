class Solution {
    long ans = 0;

    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
//        nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff
//        nums1[i] - nums2[i] <= nums1[j] - nums2[j] + diff
//        nums[i] <= nums[j] + diff

        int N = nums2.length;
        int[] diff = new int[N];

        for (int i = 0; i < N; i++)
            diff[i] = nums1[i] - nums2[i];

        mergeSort(diff, 0, N - 1, k);
        return ans;
    }

    private void mergeSort(int[] diff, int l, int r, int k) {
        if (l == r)
            return;

        int m = l + (r - l) / 2;
        mergeSort(diff, l, m, k);
        mergeSort(diff, m + 1, r, k);

        merge(diff, l, m, r, k);
    }

    private void merge(int[] diff, int l, int m, int r, int k) {
        int start = l, end = m + 1;

        while (start <= m && end <= r) {
            if (diff[start] <= diff[end] + k) {
                ans += r - end + 1;
                start++;
            } else {
                end++;
            }
        }

        Arrays.sort(diff, l, r + 1);
    }
}