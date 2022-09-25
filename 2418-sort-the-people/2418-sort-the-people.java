class Solution {
    public String[] sortPeople2(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        int N = names.length;
        String[] ans = new String[N];

        for (int i = 0; i < N; i++)
            map.put(heights[i], names[i]);

        Arrays.sort(heights);

        for (int i = 0; i < N; i++)
            ans[N - 1 - i] = map.get(heights[i]);

        return ans;
    }

    public String[] sortPeople(String[] names, int[] heights) {
        int maxH = Integer.MIN_VALUE;
        int minH = Integer.MAX_VALUE;
        int N = names.length;

        for (int i = 0; i < N; i++) {
            maxH = Math.max(maxH, heights[i]);
            minH = Math.min(minH, heights[i]);
        }

        int[] map = new int[maxH - minH + 1];
        Arrays.fill(map, -1);

        for (int i = 0; i < N; i++)
            map[heights[i] - minH] = i;

        String[] ans = new String[N];
        int idx = 0;

        for (int i = map.length - 1; i >= 0; i--)
            if (map[i] != -1)
                ans[idx++] = names[map[i]];

        return ans;
    }
}