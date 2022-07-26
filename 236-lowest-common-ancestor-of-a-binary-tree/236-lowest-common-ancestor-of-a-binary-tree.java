/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		Deque<TreeNode> stack = new ArrayDeque<>();
		Map<TreeNode, TreeNode> parents = new HashMap<>();

		stack.push(root);
		parents.put(root, null);

		while (!parents.containsKey(p) || !parents.containsKey(q)) {
			TreeNode node = stack.pop();

			if (node.left != null) {
				parents.put(node.left, node);
				stack.push(node.left);
			}

			if (node.right != null) {
				parents.put(node.right, node);
				stack.push(node.right);
			}
		}

		Set<TreeNode> ancestors = new HashSet<>();

		while (p != null) {
			ancestors.add(p);
			p = parents.get(p);
		}

		while (!ancestors.contains(q)) {
			q = parents.get(q);
		}

		return q;

	}
}