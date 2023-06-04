class Solution {
    public int minimizedStringLength(String s) {
        boolean[] set = new boolean[26];
        
        for (int i = 0; i < s.length(); i++) {
           set[s.charAt(i)-'a'] = true; 
        }
        
        int ans = 0;
        
        for(var isPresent: set) ans += isPresent ? 1 : 0;
        
        return ans;
    }
}