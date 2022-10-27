class Solution {
    public boolean isSubsequence(String s, String t) {
        int T = t.length(), S = s.length();
        int i = 0, j = 0;
        
        if(S == 0) return true;
        
        while(i < T) {
            if(t.charAt(i++) == s.charAt(j) && ++j == s.length()) 
                return true;
        }

        return false;
    }
}