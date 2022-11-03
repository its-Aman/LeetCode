class Solution {
    public int largestVariance(String s) {
        int[] freq = new int[26];        
        int ans = 0;
        
        for(char c: s.toCharArray()) 
            ++freq[c-'a'];

        for(int a = 0; a < 26; a++) {
            for(int b = 0; b < 26; b++) {
                int remA = freq[a],
                    remB = freq[b];
                
                if(a == b || remA*remB == 0)
                    continue;
                
                int freqA = 0,
                    freqB = 0;

                for(char ch: s.toCharArray()) {
                    int c = ch - 'a';
                    
                    freqB += c == b ? 1 : 0;
                    freqA += c == a ? 1 : 0;
                    remA -= c == a ? 1 : 0;
                    
                    if(freqA > 0)
                        ans = Math.max(ans, freqB - freqA);
                    
                    if(freqB < freqA && remA >= 1)
                        freqB = freqA = 0;
                }
            }
        }
        
        return ans;
    }
}