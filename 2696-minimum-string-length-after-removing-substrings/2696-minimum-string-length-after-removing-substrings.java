class Solution {
    public int minLength(String s) {
        if (!s.contains("AB") && !s.contains("CD")) return s.length();
        return minLength(s.replace("AB", "").replace("CD", ""));
    }
}