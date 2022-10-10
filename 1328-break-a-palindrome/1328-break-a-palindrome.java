class Solution {
    public String breakPalindrome(String S) {
        var c = S.toCharArray();
        int N = S.length();
        
        for(int i = 0; i < N / 2; i++) {
                
            if(c[i] != 'a') {
                c[i] = 'a';
                return String.valueOf(c);
            }
        }
        
        c[N - 1] = 'b';
        
        return N == 1 ? "" : String.valueOf(c);

    }
}