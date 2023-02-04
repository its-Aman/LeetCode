class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int N1 = s1.length();
        int N2 = s2.length();
        
        if(N1 > N2) {
            return false;
        }

        int[] m1 = new int[26];
        int[] m2 = new int[26];

        for(int i = 0; i < N1; i++) {
            m1[s1.charAt(i) - 'a'] += 1;
            m2[s2.charAt(i) - 'a'] += 1;
        }
        
        for(int i = 0; i < N2 - N1; i++) {
            if(isMatch(m1, m2)) {
                return true;
            }
            
            m2[s2.charAt(i + N1) - 'a'] += 1;
            m2[s2.charAt(i) - 'a'] -= 1;
        }
        
        return isMatch(m1, m2);
    }
    
    private boolean isMatch(int[] m1, int[] m2) {
        for(int j = 0; j < 26; j++) {
            if(m1[j] != m2[j]) {
                return false;
            }
        }
        return true;
    }
}

class Solution2 {
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