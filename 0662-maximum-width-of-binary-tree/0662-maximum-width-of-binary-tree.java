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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        int ans = 0;

        q.offer(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int minimal = q.peek().getValue();
            int start = 0, end = 0;

            for (int i = 0; i < size; i++) {
                var currP = q.poll();
                var curr = currP.getKey();
                int idx = currP.getValue() - minimal;

                if (i == 0) {
                    start = idx;
                }

                if (i + 1 == size) {
                    end = idx;
                }

                if (curr.left != null) {
                    q.offer(new Pair<>(curr.left, 2 * idx + 1));
                }

                if (curr.right != null) {
                    q.offer(new Pair<>(curr.right, 2 * idx + 2));
                }
            }

            ans = Math.max(ans, end - start + 1);
        }

        return ans;
    }
}