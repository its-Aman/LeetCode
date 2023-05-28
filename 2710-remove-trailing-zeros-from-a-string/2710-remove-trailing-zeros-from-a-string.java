class Solution {
    public String removeTrailingZeros(String num) {
        int N = num.length(), i;

        for (i = N - 1; i >= 0; i--) {
            if (num.charAt(i) != '0') break;
        }

        return num.substring(0, i+1);
    }
}