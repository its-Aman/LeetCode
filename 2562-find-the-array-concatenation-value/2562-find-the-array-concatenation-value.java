class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int N = nums.length;
        long ans = 0;

        for (int i = 0, j = N - 1; i < j; i++, j--) {
            ans += Long.parseLong(String.valueOf(nums[i]) + String.valueOf(nums[j]));
        }

        if (N % 2 == 1) {
            ans += nums[N / 2];
        }

        return ans;
    }

}