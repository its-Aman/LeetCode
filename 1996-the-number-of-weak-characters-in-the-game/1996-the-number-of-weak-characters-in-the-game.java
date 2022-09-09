class Solution {
    public int numberOfWeakCharacters_NlogN(int[][] properties) {
        int max_defence = 0, ans = 0;
        Arrays.sort(properties, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);

        for (int[] prop : properties) {
            ans += prop[1] < max_defence ? 1 : 0;
            max_defence = Math.max(max_defence, prop[1]);
        }

        return ans;
    }
    
    public int numberOfWeakCharacters(int[][] properties) {
        int[] max_defence = new int[100002];
        int ans = 0;

        for (int[] prop : properties)
            max_defence[prop[0]] = Math.max(max_defence[prop[0]], prop[1]);

        for (int i = 100000; i > 0; --i)
            max_defence[i - 1] = Math.max(max_defence[i - 1], max_defence[i]);

        for (int[] prop : properties)
            ans += max_defence[prop[0] + 1] > prop[1] ? 1 : 0;

        return ans;
    }
}