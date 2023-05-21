class Solution {
    public String makeSmallestPalindrome(String s) {
        int N = s.length();
        int x = 0, y = N - 1;
        char[] chars = s.toCharArray();

        while (x < y) {
            chars[y] = chars[x] = (char)Math.min((int)chars[y], (int)chars[x]);
            x++;
            y--;
        }

        return new String(chars);
    }
}