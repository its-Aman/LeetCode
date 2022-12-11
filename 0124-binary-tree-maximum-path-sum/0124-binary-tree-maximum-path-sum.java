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
    int ans = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
    
        dfs(root);
        
        return ans;
    }
    
    private int dfs(TreeNode node) {
        if(node == null)
            return 0;
        
        int left = dfs(node.left),
            right = dfs(node.right);
        
        int maxSumWithCurrNode = Math.max(Math.max(left, right) + node.val, node.val);
        int maxSumWithCurrNodeAsRoot = Math.max(maxSumWithCurrNode, left + right + node.val);
        ans = Math.max(ans, maxSumWithCurrNodeAsRoot);
        
        return maxSumWithCurrNode;
    }
}