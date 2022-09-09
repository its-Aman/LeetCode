class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int max_defence = 0, ans = 0;
        Arrays.sort(properties, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);

        for (int[] prop : properties) {
            ans += prop[1] < max_defence ? 1 : 0;
            max_defence = Math.max(max_defence, prop[1]);
        }

        return ans;
    }
}