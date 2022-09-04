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
    Map<Integer, PriorityQueue<int[]>> map = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        this.go(root, 0, 0);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for (int k : keys) {
            PriorityQueue<int[]> items = this.map.get(k);
            List<Integer> item = new ArrayList<>();

            while (!items.isEmpty())
                item.add(items.poll()[1]);
            ans.add(item);
        }

        return ans;
    }

    private void go(TreeNode node, int r, int c) {
        if (node == null)
            return;

        map.computeIfAbsent(c, k -> new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]))
                .add(new int[]{r, node.val});
        this.go(node.left, r + 1, c - 1);
        this.go(node.right, r + 1, c + 1);
    }
}