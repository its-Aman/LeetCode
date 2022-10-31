class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(p1 -> p1[1]));

        int curr = -1001, ans = 0;

        for (int[] pair : pairs) {

            int head = pair[0], tail = pair[1];
            
            if (head > curr) {
                curr = tail;
                ++ans;
            }
        }

        return ans;
    }
}