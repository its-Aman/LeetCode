class Solution {
    int ans = 0;
    public int minIncrements(int n, int[] cost) {
        dfs(0, cost);
        return ans;
    }

    private int dfs(int node, int[] cost) {
        if (node >= cost.length) return 0;
        int leftNode = dfs(2 * node + 1, cost),
                rightNode = dfs(2 * node + 2, cost);
        ans += Math.abs(leftNode - rightNode);
        return cost[node] + Math.max(leftNode, rightNode);
    }
}