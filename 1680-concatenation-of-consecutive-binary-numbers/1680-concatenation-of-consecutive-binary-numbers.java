class Solution {
    public int concatenatedBinary(int n) {
        long ans = 0;
        int M = 1_000_000_007;
        int bitCnt = 0;

        for (int i = 1; i <= n; i++) {
            if((i & (i - 1)) == 0)
                ++bitCnt;

            ans = ((ans << bitCnt) | i) % M;
        }

        return (int) (ans % M);
    }
}