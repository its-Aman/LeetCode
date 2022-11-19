class Solution {
    public int[][] outerTrees(int[][] trees) {
        Arrays.sort(trees, (y, x) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        Stack<int[]> hull = new Stack<>();
        int N = trees.length;

        for (int i = 0; i < N; i++) {
            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), trees[i]) > 0)
                hull.pop();
            hull.push(trees[i]);
        }
        hull.pop();

        for (int i = N - 1; i >= 0; i--) {
            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), trees[i]) > 0)
                hull.pop();
            hull.push(trees[i]);
        }
        var set = new HashSet<int[]>(hull);
        return set.toArray(new int[set.size()][]);
    }

    private int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }
}