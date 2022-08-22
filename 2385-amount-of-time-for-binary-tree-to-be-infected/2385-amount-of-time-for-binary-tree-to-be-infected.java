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
	private Map<TreeNode, TreeNode> parents = new HashMap<>();
	TreeNode begin;

	public int amountOfTime(TreeNode root, int start) {
		int ans = 0;
		Queue<TreeNode> q = new LinkedList<>();
		Set<Integer> seen = new HashSet<>();

		this.dfs(root, null, start);

		q.offer(begin);
		seen.add(start);

		while (!q.isEmpty()) {
			int size = q.size();

			while (size-- > 0) {
				TreeNode curr = q.poll();

				if (curr.left != null && !seen.contains(curr.left.val)) {
					q.offer(curr.left);
					seen.add(curr.left.val);
				}

				if (curr.right != null && !seen.contains(curr.right.val)) {
					q.offer(curr.right);
					seen.add(curr.right.val);
				}

				if (this.parents.get(curr) != null && !seen.contains(this.parents.get(curr).val)) {
					q.add(this.parents.get(curr));
					seen.add(this.parents.get(curr).val);
				}
			}
			ans += 1;
		}

		return ans - 1;
	}

	private void dfs(TreeNode curr, TreeNode parent, int start) {
		if (curr == null)
			return;

		if (curr.val == start)
			begin = curr;

		this.parents.putIfAbsent(curr, parent);
		this.dfs(curr.left, curr, start);
		this.dfs(curr.right, curr, start);
	}
}