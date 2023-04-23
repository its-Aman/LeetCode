class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int N = nums.length;
        int[] ans = new int[N - k + 1], cnts = new int[50];

        for (int i = 0; i < N; i++) {
            if (nums[i] < 0) {
                cnts[nums[i] + 50]++;
            }

            if (i - k >= 0 && nums[i - k] < 0) {
                cnts[nums[i - k] + 50]--;
            }

            if (i - k + 1 < 0) {
                continue;
            }

            for (int j = 0, cnt = 0; j < 50; j++) {
                cnt += cnts[j];
                if (cnt >= x) {
                    ans[i - k + 1] = j - 50;
                    break;
                }
            }
        }

        return ans;
    }
}