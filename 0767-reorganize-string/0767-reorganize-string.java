class Solution {
    public String reorganizeString(String s) {
        int[] counter = new int[26];
        char[] ch = s.toCharArray();
        int N = ch.length;
        int max = 0, letter = -1;

        for (char c : ch)
            counter[c - 'a']++;

        for (int i = 0; i < 26; i++) {
            if (counter[i] > max) {
                letter = i;
                max = counter[i];
            }
        }

        if (max > (N + 1) / 2)
            return "";

        char[] ans = new char[N];
        int idx = 0;

        while (counter[letter] > 0) {
            ans[idx] = (char) (letter + 'a');
            idx += 2;
            counter[letter]--;
        }

        for (int i = 0; i < 26; i++) {
            while (counter[i] > 0) {
                if (idx >= N)
                    idx = 1;
                ans[idx] = (char) (i + 'a');
                idx += 2;
                counter[i]--;
            }
        }

        return String.valueOf(ans);
    }
}