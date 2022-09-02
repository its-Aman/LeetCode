class Solution {
    public int balancedString(String S) {
        int N = S.length(), ans = N;
        int[] count = new int[128];

        for (int i = 0; i < N; i++)
            ++count[S.charAt(i)];

        for (int left = 0, right = 0; right < N; right++) {
            --count[S.charAt(right)];

            while (left < N && checkValid(count, N / 4)) {
                ans = Math.min(ans, right - left + 1);
                ++count[S.charAt(left++)];
            }
        }

        return ans;
    }

    private boolean checkValid(int[] count, int K) {
        for (int c : count)
            if (c > K)
                return false;

        return true;
    }
}