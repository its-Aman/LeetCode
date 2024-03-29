class Solution {
    public int balancedString(String S) {
        int N = S.length(), ans = N, K = N / 4;
        int[] count = new int[128];

        for (int i = 0; i < N; i++)
            ++count[S.charAt(i)];

        for (int left = 0, right = 0; right < N; right++) {
            --count[S.charAt(right)];

            while (left < N && count['Q'] <= K && count['W'] <= K && count['E'] <= K && count['R'] <= K) {
                ans = Math.min(ans, right - left + 1);
                ++count[S.charAt(left++)];
            }
        }

        return ans;
    }
}