class Solution {
    public boolean checkIfPangram(String sentence) {
        int seen = 0;
        
        for(var ch: sentence.toCharArray())
            seen |= 1 << (ch-'a');
                
        return (seen+1) == (1 << 26);
    }
}