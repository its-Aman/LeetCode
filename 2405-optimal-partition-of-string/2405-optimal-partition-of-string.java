class Solution {
    public int partitionString(String S) {
        int ans = 1, flag = 0;

        for (int i = 0; i < S.length(); i++) {
            int n = S.charAt(i) - 'a';
            int bit = 1 << n;
            if ((flag & bit) >= 1) {
                flag = 0;
                ++ans;
            }

            flag = flag | bit;
        }

        return ans;
    }
}