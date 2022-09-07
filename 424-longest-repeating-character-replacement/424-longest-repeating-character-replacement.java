class Solution {
    public int characterReplacement(String S, int K) {
        int[] count = new int[26];
        int maxF = 0, ans = 0;
        
        for(int i = 0; i < S.length(); i++) {
            maxF = Math.max(maxF, ++count[S.charAt(i) - 'A']);
            
            if(ans - maxF < K)
                ++ans;
            else
                --count[S.charAt(i - ans) - 'A'];
        }
        
        return ans;
    }
}