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
    public TreeNode pruneTree(TreeNode root) {
        TreeNode dummy = new TreeNode(1, root, null);
        pruneNode(root, dummy, true);
        return dummy.left;
    }
    
    private void pruneNode(TreeNode curr, TreeNode parent, boolean isLeft) {
        if(curr == null)
            return;
        
        pruneNode(curr.left, curr, true);
        pruneNode(curr.right, curr, false);
        
        if(curr.val == 0 && curr.left == null && curr.right == null) {
            if(isLeft)
                parent.left = null;
            else
                parent.right = null;
        }
    }
}