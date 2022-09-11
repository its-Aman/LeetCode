class Solution {
    public int partitionString(String S) {
        int N = S.length(), ans = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            if (set.contains(S.charAt(i))) {
                ++ans;
                set.clear();
            }

            set.add(S.charAt(i));
        }

        if (set.size() > 0)
            ++ans;

        return ans;
    }
}