class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
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
}