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
    int min = Integer.MAX_VALUE;
    TreeNode prevNode;
    
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }
    
    private void inOrder(TreeNode node) {
        if(node == null) return;
        
        inOrder(node.left);
        
        if(prevNode != null) min = Math.min(min, node.val-prevNode.val);
        
        prevNode = node;
        
        inOrder(node.right);
    }
}