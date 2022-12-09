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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }
    
    private int dfs(TreeNode node, int currMax, int currMin) {
        if(node == null)
            return currMax - currMin;
        
        currMax = Math.max(currMax, node.val);
        currMin = Math.min(currMin, node.val);
        
        int left = dfs(node.left, currMax, currMin);
        int right = dfs(node.right, currMax, currMin);
        
        return Math.max(left, right);
    }
}