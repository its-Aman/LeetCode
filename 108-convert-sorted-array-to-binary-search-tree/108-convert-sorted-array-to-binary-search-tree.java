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

		if (nums.length == 0)
			return null;

		return new TreeNode(nums[nums.length / 2], this.sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2)),
				this.sortedArrayToBST(Arrays.copyOfRange(nums, 1 + (nums.length / 2), nums.length)));

	}
}