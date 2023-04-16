class Solution {
    public int addMinimum(String word) {
        int N = word.length();
        int ans = 0;
        char c = 'z';

        for (char ch : word.toCharArray()) {
            if (ch <= c) {
                ans++;
            }
            c = ch;
        }

        return (ans * 3) - N;
    }
}