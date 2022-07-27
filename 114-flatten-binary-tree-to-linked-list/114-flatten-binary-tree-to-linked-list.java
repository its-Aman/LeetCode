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
	public void flatten(TreeNode root) {
		if (root == null)
			return;

		Stack<TreeNode> rights = new Stack<>();
		TreeNode curr = root;

		while (curr != null) {
			if (curr.left != null) {
				if (curr.right != null)
					rights.push(curr.right);

        curr.right = curr.left;
				curr.left = null;
				curr = curr.right;
			} else if (curr.right != null) {
				curr = curr.right;
			} else {
				if (rights.size() > 0) {
					curr.right = rights.pop();
					curr = curr.right;
				} else {
					break;
				}
			}
		}
	}
}