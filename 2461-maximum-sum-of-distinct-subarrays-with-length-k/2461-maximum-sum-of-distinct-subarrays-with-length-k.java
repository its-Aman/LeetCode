class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0, sum = 0;
        int N = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (i + 1 >= k) {
                if (map.size() == k)
                    ans = Math.max(ans, sum);

                sum -= nums[i - k + 1];
                map.computeIfPresent(nums[i - k + 1], (_k, _v) -> _v == 1 ? null : _v - 1);
            }
        }

        return ans;
    }
}