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
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> ans = new ArrayList<>();
      Queue<TreeNode> q = new LinkedList<>();

      q.offer(root);

      while (!q.isEmpty()) {
        int N = q.size();
        List<Integer> curr = new ArrayList<>();

        if(root == null)
          return ans;

        for (int i = 0; i < N; i++) {
          TreeNode node = q.poll();
          curr.add(node.val);
          if(node.left != null)
            q.offer(node.left);

          if(node.right != null)
            q.offer(node.right);
        }
        ans.add(curr);
      }

      return ans;
    }
}