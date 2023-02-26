class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N], prefix = new int[N + 1], postfix = new int[N + 1];

        for (int i = 0; i < N; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int i = N; i > 0; i--) {
            postfix[i - 1] = postfix[i] + nums[i - 1];
        }

        for (int i = 0; i < N; i++) {
            ans[i] = Math.abs(prefix[i] - postfix[i+1]);
        }

        return ans;
    }
}