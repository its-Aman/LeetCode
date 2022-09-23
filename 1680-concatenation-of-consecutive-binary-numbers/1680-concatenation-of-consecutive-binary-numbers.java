class Solution {
    public int concatenatedBinary(int n) {
        long ans = 0;
        int M = 1_000_000_007;

        for (int i = 1; i <= n; i++)
            ans = ((ans << log2(i)) | i) % M;

        return (int) (ans % M);
    }

    private int log2(long x) {
        return 1 + (int) (Math.log(x) / Math.log(2));
    }
}