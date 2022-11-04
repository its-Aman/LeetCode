class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int N = s.length();
        Set<Character> vowels = new HashSet<>(List.of('a','e','i','o','u','A','E','I','O','U'));

        for (int l = 0, r = N - 1; l < r; ) {
            if (vowels.contains(ch[l]) && vowels.contains(ch[r])) {
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;
                l++;
                r--;
            }
            if (!vowels.contains(ch[l]))
                l++;
            if (!vowels.contains(ch[r]))
                r--;
        }

        return String.valueOf(ch);
    }
}