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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1)
            return new TreeNode(val, root, null);

        addRow(root, val, depth);
        return root;
    }

    public void addRow(TreeNode root, int val, int depth) {
        if(root == null)
            return;
        
        depth--;

        if(depth - 1 == 0) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
            return;
        }
                
        addOneRow(root.left, val, depth);
        addOneRow(root.right, val, depth);
    }
}