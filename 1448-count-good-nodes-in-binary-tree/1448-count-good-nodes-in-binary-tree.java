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
    private int ans = 0;
    
    public int goodNodes(TreeNode root) {
        this.checkNode(root.val, root);
        return this.ans;
    }
    
    private void checkNode(int currValue, TreeNode node) {
        
        if(node == null)
            return;
        
        if(currValue <= node.val)
            this.ans += 1;
        
        this.checkNode(Math.max(currValue, node.val), node.left);
        this.checkNode(Math.max(currValue, node.val), node.right);
    }
}