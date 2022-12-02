class Solution {
    public boolean closeStrings(String w1, String w2) {
        int N1 = w1.length(),
            N2 = w2.length();
        
        if(N1 != N2)
            return false;
        
        int[] f1 = new int[26],
                f2 = new int[26];
        
        for(char c: w1.toCharArray())
            f1[c-'a']++;

        for(char c: w2.toCharArray()) {
            if(f1[c-'a'] == 0)
                return false;
            f2[c-'a']++;
        }
        
        Arrays.sort(f1);
        Arrays.sort(f2);
        
        for(int i = 0; i < 26; i++)
            if(f1[i] != f2[i])
                return false;
        
        return true;
    }
}