class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dict = new int[26];
        
        for(char c: magazine.toCharArray())
            dict[c-'a'] += 1;
        
        for(char rn: ransomNote.toCharArray()) 
            if(dict[rn-'a'] == 0)
                return false;
            else
                dict[rn-'a'] -= 1;
        
        return true;
    }
}