class Solution {

    public int minSubArrayLen(int K, int[] nums) {
        int N = nums.length, ans = Integer.MAX_VALUE;
        int[] prefix = new int[N + 1];

        for (int i = 0; i < N; i++) {
            prefix[i + 1] = nums[i] + prefix[i];
        }

        for (int i = N; i >= 0; i--) {
            int idx = this.upperBound(prefix, prefix[i] - K, i);
            if (idx != 0 && idx <= i) {
                ans = Math.min(ans, i - idx + 1);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private int upperBound(int[] arr, int K, int N) {
        int lo = 0, hi = N;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (K >= arr[mid])
                lo = mid + 1;
            else
                hi = mid;
        }

        if (lo < N && arr[lo] <= K)
            lo += 1;

        return lo;
    }
    
    
}