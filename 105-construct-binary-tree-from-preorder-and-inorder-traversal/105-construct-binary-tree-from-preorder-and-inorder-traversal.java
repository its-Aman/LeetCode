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

	int pIdx;
	int iIdx;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.pIdx = 0;
        this.iIdx = 0;
        
		return this.buildTree(preorder, inorder, Integer.MIN_VALUE);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder, int stop) {
        if(this.pIdx >= preorder.length){
            return null;
        }
        
        if(inorder[this.iIdx] == stop) {
            this.iIdx += 1;
            return null;
        }

		int rootVal = preorder[this.pIdx++];
		TreeNode root = new TreeNode(rootVal);

		root.left = this.buildTree(preorder, inorder, rootVal);
		root.right = this.buildTree(preorder, inorder, stop);

		return root;
	}
}