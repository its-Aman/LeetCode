class Solution {
    public long appealSum(String s) {
        long ans = 0;
        int N = s.length();
        int[] freq = new int[26];
        Arrays.fill(freq, -1);

        for (int i = 0; i < N; i++) {
            ans += (long) (i - freq[s.charAt(i) - 'a']) * (N - i);
            freq[s.charAt(i) - 'a'] = i;
        }

        return ans;
    }
}