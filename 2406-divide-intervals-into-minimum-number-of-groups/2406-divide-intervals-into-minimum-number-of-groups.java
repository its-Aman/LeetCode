class Solution {
    public int minGroups(int[][] intervals) {
        int ans = 0;
        int[] count = new int[(int) (1e6 + 2)];

        for (var interval : intervals) {
            ++count[interval[0]];
            --count[interval[1] + 1];
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
            ans = Math.max(ans, count[i]);
        }

        return ans;
    }
}