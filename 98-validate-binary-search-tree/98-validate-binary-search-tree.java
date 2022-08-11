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
    public boolean isValidBST(TreeNode root) {       
        return this.isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);        
    }
    
    public boolean isValidBST(TreeNode root, Double min, Double max) {
        if(root == null)
            return true;
        
        if(root.val <= min || root.val >= max)
            return false;
        
        return this.isValidBST(root.left, min, new Double(root.val)) && this.isValidBST(root.right, new Double(root.val), max);
    }
}