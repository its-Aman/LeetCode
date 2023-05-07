class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N];
        int[] cnt1 = new int[51], cnt2 = new int[51];


        for (int i = 0; i < N; i++) {
            cnt1[nums[i]]++;
        }

        for (int i = 0; i < N; i++) {
            cnt2[nums[i]]++;
            cnt1[nums[i]]--;
            for (int j = 0; j < 51; j++) {
                ans[i] += cnt2[j] > 0 ? 1 : 0;
                ans[i] -= cnt1[j] > 0 ? 1 : 0;
            }
        }

        return ans;
    }
}