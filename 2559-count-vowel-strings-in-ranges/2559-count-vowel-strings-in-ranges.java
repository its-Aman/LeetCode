class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int N = words.length;
        int[] line = new int[N + 1];

        for (int i = 0; i < N; i++) {
            line[i + 1] = line[i];

            if(checkVowel(words[i].charAt(0)) && checkVowel(words[i].charAt(words[i].length() - 1))) {
                line[i + 1] += 1;
            }
         }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            ans[i] = line[r+1] - line[l];
        }

        return ans;
    }

    private boolean checkVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}