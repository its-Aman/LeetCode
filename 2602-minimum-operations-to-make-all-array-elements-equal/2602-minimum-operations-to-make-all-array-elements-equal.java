class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int N = nums.length;
        List<Long> ans = new ArrayList<>();

        Arrays.sort(nums);
        long[] prefix = new long[N + 1];

        for (int i = 0; i < N; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (var q : queries) {
            int idx = bisect_left(nums, q);
            ans.add(q * (2L * idx - N) + prefix[N] - 2 * prefix[idx]);
        }
        
        return ans;
    }

    private int bisect_left(int[] nums, int k) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] < k) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return l;
    }
}