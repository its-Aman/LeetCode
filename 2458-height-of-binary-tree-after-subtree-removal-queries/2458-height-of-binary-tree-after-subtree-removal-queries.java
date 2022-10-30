/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, Integer> Depth = new HashMap<>();
    Map<Integer, Integer> Height = new HashMap<>();
    Map<Integer, PriorityQueue<int[]>> Cousins = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] queries) {
        int N = queries.length;
        int[] ans = new int[N];

        dfs(root, 0);

        for (int nodeVal : Depth.keySet()) {
            int depth = Depth.get(nodeVal);
            if (!Cousins.containsKey(depth))
                Cousins.put(depth, new PriorityQueue<>(Comparator.comparingInt(p -> p[0])));

            Cousins.get(depth).offer(new int[]{-Height.get(nodeVal), nodeVal});
        }

        for (int i = 0; i < N; i++) {
            int query = queries[i];
            int depth = Depth.get(query);
            PriorityQueue<int[]> cousinList = Cousins.get(depth);

            if (cousinList.size() == 1)
                ans[i] = depth - 1;
            else if (cousinList.peek()[1] == queries[i]) {
                int[] temp = cousinList.poll();
                ans[i] = -cousinList.peek()[0] + depth;
                cousinList.offer(temp);
            } else {
                ans[i] = -cousinList.peek()[0] + depth;
            }
        }

        return ans;
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) return -1;

        Depth.put(node.val, depth);

        int leftHeight = dfs(node.left, depth + 1);
        int rightHeight = dfs(node.right, depth + 1);
        int maxHeight = 1 + Math.max(leftHeight, rightHeight);

        Height.put(node.val, maxHeight);
        return maxHeight;
    }
}