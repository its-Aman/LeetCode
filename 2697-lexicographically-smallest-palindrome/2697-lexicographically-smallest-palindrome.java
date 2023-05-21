class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        
        for(int x=0, y=s.length() - 1; x<y; x++, y--) {
            chars[y] = chars[x] = (char)Math.min((int)chars[y], (int)chars[x]);
        }

        return new String(chars);
    }
}