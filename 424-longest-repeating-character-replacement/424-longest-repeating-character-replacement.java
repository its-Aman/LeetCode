class Solution {
    public int characterReplacement(String S, int K) {
        int[] count = new int[26];
        int N = S.length(), maxF = 0, start = 0;
        
        for(int i = 0; i < S.length(); i++) {
            maxF = Math.max(maxF, ++count[S.charAt(i) - 'A']);
            
            if(i - start + 1 > maxF + K)
                --count[S.charAt(start++) - 'A'];
        }
        
        return N - start;
    }
}