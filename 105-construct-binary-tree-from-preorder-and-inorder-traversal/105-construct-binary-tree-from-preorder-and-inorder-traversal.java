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

	Map<Integer, Integer> map = new HashMap<>();
	int pIdx;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.pIdx = 0;

		for (int i = 0; i < inorder.length; i++)
			map.put(inorder[i], i);

		return this.buildTree(preorder, 0, preorder.length - 1);
	}

	public TreeNode buildTree(int[] preorder, int left, int right) {

		if (left > right)
			return null;

		int rootVal = preorder[this.pIdx];
		this.pIdx += 1;
		TreeNode root = new TreeNode(rootVal);

		root.left = this.buildTree(preorder, left, map.get(rootVal) - 1);
		root.right = this.buildTree(preorder, map.get(rootVal) + 1, right);

		return root;
	}
}