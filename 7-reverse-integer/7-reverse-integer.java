class Solution {
    public int reverse(int x) {
        boolean isNeg = x < 0;
        x = Math.abs(x);
        long ans = 0;

        while (x > 0) {
            int digit = x % 10;
            ans = ans * 10 + digit;
            x /= 10;

            if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE)
                return 0;
        }

        if (isNeg)
            ans = -ans;

        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE)
            return 0;

        return (int) ans;
    }
}