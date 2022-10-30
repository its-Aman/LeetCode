class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long ans = 0, mul = 1;

        for (; digitSum(n) > target; mul *= 10) {
            long nn = 10 - (n % 10);
            ans += mul * (nn % 10);
            n = (n + (nn % 10)) / 10;
        }

        return ans;
    }

    private long digitSum(long number) {
        long sum = 0;

        for (sum = 0; number != 0; number /= 10)
            sum = sum + number % 10;

        return sum;
    }
}