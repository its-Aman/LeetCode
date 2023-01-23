class Solution {

    public int alternateDigitSum(int n) {
        int sign = 1;
        int ans = 0;

        for (; n > 0; n /= 10) {
            sign = -sign;
            ans += sign * (n % 10);
        }
        
        return ans * sign;
    }
}