class Solution {
    public int maxVowels(String s, int k) {
        int ans = 0;
        
        for(int i=0, curr=0; i<s.length(); i++) {
            if(i - k >= 0) {
                curr -= isVowel(s.charAt(i-k));
            }
            
            curr += isVowel(s.charAt(i));
            ans = Math.max(ans, curr);
        }
        
        return ans;
    }
    
    private int isVowel(char c) {
        var isV = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');

        return isV ? 1 : 0;
    }
}