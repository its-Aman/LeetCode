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
    private int ans;
    
    public int sumNumbers(TreeNode root) {
        bfs(root, 0);
        
        return ans;
    }
    
    private void bfs(TreeNode node, int num) {
        if(node == null)
            return;
        
        num = (num * 10) + node.val;
        
        if(node.left != null)
            bfs(node.left, num);
        
        if(node.right != null)
            bfs(node.right, num);

        if(node.left == null && node.right == null)
            ans += num;
    }
}