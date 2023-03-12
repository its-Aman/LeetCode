class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;

        while (left <= right) {
            int N = words[left].length();
            
            if (isVowel(words[left].charAt(0)) && isVowel(words[left].charAt(N - 1))) {
                ans += 1;
            }

            left++;
        }

        return ans;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}