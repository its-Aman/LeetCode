class Solution {
    int[] seq = new int[26];
        
    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i < 26; i++) {
            seq[order.charAt(i)-'a'] = i;
        }
        
        for(int i = 1; i < words.length; i++) {
            if(!check(words[i-1], words[i])) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean check(String a, String b) {
        int N1 = a.length(), N2 = b.length();
        
        for(int i = 0; i < N1 && i < N2; i++) {
            int x = a.charAt(i) - 'a', y = b.charAt(i) - 'a';
            
            if(x != y) {
                return seq[x] < seq[y];
            }
        }
        
        return N1 <= N2;
    }
}