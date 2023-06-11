class Solution {
    public String smallestString(String s) {
        int N = s.length(), i = 0;
        char[] ans = s.toCharArray();
        while (i < N && ans[i] == 'a') i++;
        if (i >= N) ans[N - 1] = 'z';
        while (i < N && ans[i] != 'a') ans[i++]--;

        return String.valueOf(ans);
    }
}