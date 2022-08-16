class Solution {
    public int firstUniqChar(String S) {
        int[] alphabets = new int[26];
        Arrays.fill(alphabets, -1);
        
        for(int i = 0; i < S.length(); i++) {
            alphabets[S.charAt(i) - 'a'] += 1;
        }

        for(int i = 0; i < S.length(); i++) {
            if(alphabets[S.charAt(i) - 'a'] == 0)
                return i;
        }

        return -1;
    }
}