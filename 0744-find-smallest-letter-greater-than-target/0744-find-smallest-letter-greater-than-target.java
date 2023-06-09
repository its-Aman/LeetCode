class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int N = letters.length;
        
        if(target >= letters[N-1]) return letters[0];
        
        int l = 0, r = N-1;
        
        while(l <= r) {
            int m = l + (r-l)/2;
            if(letters[m] <= target) l = m+1;
            else r = m-1;
        }

        return letters[l];
    }
}