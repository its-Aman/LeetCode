class Solution {
    int[] ch = new int[26];
    int N1, N2;
    
    public boolean checkInclusion(String s1, String s2) {
        N1 = s1.length();
        N2 = s2.length();
        int total = N1;

        for(int i = 0; i < N1; i++) {
            ch[s1.charAt(i) - 'a'] += 1;
        }
        
        for(int i = 0; i < N2; i++) {
            if(ch[s2.charAt(i) - 'a'] > 0 && checkStr(s2, i)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean checkStr(String s, int idx) {
        if(idx + N1 > N2) {
            return false;
        }
        
        int i = 0, total = 0;
        int[] local = new int[26];
        
        for(int j = 0; j < 26; j++) {
            local[j] = ch[j];    
        }
        
        while(i < N1 && idx + i < N2) {
            if(local[s.charAt(idx + i) - 'a'] > 0) {
                local[s.charAt(idx + i) - 'a'] -= 1;
                total += 1;
            } 
            i++;
        }
        
        return total == N1;
    }
}