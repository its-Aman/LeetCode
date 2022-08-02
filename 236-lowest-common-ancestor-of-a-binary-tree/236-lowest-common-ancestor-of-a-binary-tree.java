/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode P, TreeNode Q) {
        if(root == null || root.equals(P) || root.equals(Q))
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, P, Q);
        TreeNode right = lowestCommonAncestor(root.right, P, Q);
        
        if(left == null)
            return right;
        else if(right == null)
            return left;
        else
            return root;
    }
}