class Solution {

    public int subarraysWithKDistinct(int[] nums, int K) {
        return this.subArrayWithAtmostKDistince(nums, K) - this.subArrayWithAtmostKDistince(nums, K - 1);
    }

    private int subArrayWithAtmostKDistince(int[] nums, int K) {
        if (K == 0)
            return 0;

        int ans = 0, N = nums.length;
        int[] cnt = new int[N + 1];

        for (int left = 0, right = 0; right < N; right++) {
            if (cnt[nums[right]] == 0)
                K -= 1;

            cnt[nums[right]] += 1;

            while (K < 0) {
                cnt[nums[left]] -= 1;
                if (cnt[nums[left]] == 0)
                    K += 1;
                left += 1;
            }
            ans += right - left + 1;
        }

        return ans;
    }
}