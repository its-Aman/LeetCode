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

	public TreeNode sortedArrayToBST(int[] nums) {
		return this.sortedArrayToBST(nums, 0, nums.length - 1);
	}

	public TreeNode sortedArrayToBST(int[] nums, int low, int hi) {
		if (low > hi)
			return null;

		int mid = low + (hi - low) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = this.sortedArrayToBST(nums, low, mid - 1);
		node.right = this.sortedArrayToBST(nums, mid + 1, hi);

		return node;
	}    
}