class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int N = envelopes.length, ans = 0;
        int[] dp = new int[N];

        Arrays.sort(envelopes, (e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);

        for (int i = 0; i < N; i++) {
            int h = envelopes[i][1],
                    l = 0, r = ans;

            while (l < r) {
                int m = l + (r - l) / 2;
                if (dp[m] < h)
                    l = m + 1;
                else
                    r = m;
            }
            dp[l] = h;

            if (l == ans)
                ans++;
        }

        return ans;
    }
}