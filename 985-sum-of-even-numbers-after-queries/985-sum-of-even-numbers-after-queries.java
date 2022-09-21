class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int N = queries.length;
        int[] ans = new int[N];
        int evenSum = 0;

        for (int num : nums)
            evenSum += (num & 1) == 0 ? num : 0;

        for (int i = 0; i < N; i++) {
            int val = queries[i][0];
            int idx = queries[i][1];

            evenSum -= (nums[idx] & 1) == 0 ? nums[idx] : 0;
            nums[idx] += val;
            evenSum += (nums[idx] & 1) == 0 ? nums[idx] : 0;

            ans[i] = evenSum;
        }

        return ans;
    }
}