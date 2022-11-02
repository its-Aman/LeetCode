class Solution {
    Set<String> set = new HashSet<>();
    char[] genes = new char[]{'A', 'C', 'G', 'T'};
    int ans = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        for (String b : bank)
            set.add(b);

        set.add(start);

        if (!set.contains(end))
            return -1;

        bfs(start.toCharArray(), end.toCharArray(), 0);

        if (ans == Integer.MAX_VALUE)
            return -1;

        return ans;
    }

    private void bfs(char[] start, char[] end, int cnt) {
        if (Arrays.equals(start, end))
            ans = Math.min(ans, cnt);

        for (int i = 0; i < 8; i++) {
            char temp = start[i];

            for (char g : genes) {
                start[i] = g;
                String str = String.valueOf(start);
                if (set.contains(str)) {
                    set.remove(str);
                    bfs(start, end, cnt + 1);
                    set.add(str);
                }
            }
            start[i] = temp;
        }
    }
}