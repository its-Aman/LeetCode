class Solution {
    public long findScore(int[] nums) {
        long ans = 0;
        int N = nums.length;
        int[][] nnums = new int[N][2];
        boolean[] set = new boolean[N + 2];

        for (int i = 0; i < N; i++) {
            nnums[i] = new int[]{nums[i], i};
        }

        Arrays.sort(nnums, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (int i = 0; i < N; i++) {

            if (set[nnums[i][1] + 1]) {
                continue;
            }

            ans += nnums[i][0];
            set[nnums[i][1]] = set[nnums[i][1] + 1] = set[nnums[i][1] + 2] = true;
        }

        return ans;
    }
}