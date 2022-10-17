class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] freq = new int[26];
        
        for(var ch: sentence.toCharArray())
            freq[ch-'a']++;
        
        for(var f: freq)
            if(f==0)
                return false;
        
        return true;
    }
}