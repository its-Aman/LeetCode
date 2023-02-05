class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sN = s.length(), pN = p.length();
        int[] pFreq = new int[26], sFreq = new int[26];
        List<Integer> ans = new ArrayList<>();
        
        for(char c: p.toCharArray()) {
            pFreq[c-'a'] += 1;
            sFreq[c-'a'] += 1;
        }
        
        for(int i = 0; i <= sN - pN; i++) {
            if(pFreq[s.charAt(i)-'a'] > 0) {
                boolean isAnagram = true;
                
                for(int j = 0; j < pN; j++) {
                    sFreq[s.charAt(i + j)-'a'] -= 1;

                    if(sFreq[s.charAt(i + j)-'a'] < 0) {
                        isAnagram = false;
                        break;
                    }

                }
    
                if(isAnagram) {
                    ans.add(i);
                }
                
                for(int j = 0; j < 26; j++){
                    sFreq[j] = pFreq[j];
                }
            }
        }
        
        return ans;
    }
}