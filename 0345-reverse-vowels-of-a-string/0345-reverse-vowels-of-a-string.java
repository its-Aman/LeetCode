class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int N = s.length();

        for (int l = 0, r = N - 1; l < r; ) {
            if (checkVowel(ch[l]) && checkVowel(ch[r])) {
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;
                l++;
                r--;
            }
            if (!checkVowel(ch[l]))
                l++;
            if (!checkVowel(ch[r]))
                r--;
        }

        return String.valueOf(ch);
    }

    private boolean checkVowel(char c) {
        return "aeiouAEIOU".indexOf(c) > -1;
    }
}