class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sN = s.length(), pN = p.length();
        int[] pFreq = new int[26], sFreq = new int[26];
        List<Integer> ans = new ArrayList<>();
        
        if(pN > sN) {
            return ans;
        }
        
        for(int i = 0; i < pN; i++) {
            pFreq[p.charAt(i) - 'a'] += 1;
            sFreq[s.charAt(i) - 'a'] += 1;
        }
        
        for(int i = 0; i <= sN - pN; i++) {
            boolean isAnagram = true;
            
            for(int j = 0; j < 26; j++) {
                if(pFreq[j] != sFreq[j]) {
                    isAnagram = false;
                    break;
                }
            }

            if(isAnagram) {
                ans.add(i);
            }

            sFreq[s.charAt(i)-'a'] -= 1;

            if(i + pN >= sN){
                break;
            }

            sFreq[s.charAt(i + pN)-'a'] += 1;

            }
        
        return ans;
    }
}