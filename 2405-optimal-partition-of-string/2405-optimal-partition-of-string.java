class Solution {
    public int partitionString(String S) {
        int N = S.length(), ans = 1;
        int[] count = new int[26];

        for (int i = 0; i < N; i++) {
            if (count[S.charAt(i) - 'a'] == 1) {
                ++ans;
                count = new int[26];
            }
            ++count[S.charAt(i) - 'a'];
        }

        return ans;
    }
}