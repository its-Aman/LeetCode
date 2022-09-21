class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int M = nums.length;
        int N = queries.length;
        int[] ans = new int[N];
        int evenCount = 0;

        for (int i = 0; i < M; i++)
            evenCount += (nums[i] % 2) == 0 ? nums[i] : 0;

        for (int i = 0; i < N; i++) {
            int val = queries[i][0];
            int idx = queries[i][1];

            evenCount -= (nums[idx] % 2 == 0) ? nums[idx] : 0;
            nums[idx] += val;
            evenCount += (nums[idx] % 2 == 0) ? nums[idx] : 0;

            ans[i] = evenCount;
        }

        return ans;
    }
}