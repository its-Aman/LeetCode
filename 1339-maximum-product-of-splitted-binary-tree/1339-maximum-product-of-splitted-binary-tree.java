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
    private long ans = Long.MIN_VALUE, total = 0;
    
    public int maxProduct(TreeNode root) {
        total = getSum(root);
        getSum(root);
        
        return (int)(ans % (int)(1e9+7));
    }
    
    private long getSum(TreeNode node) {
        if(node == null)
            return 0;
        
        long left = getSum(node.left),
            right = getSum(node.right),
            sum = node.val + left + right;

        ans = Math.max(ans, (total - sum) * sum);
        
        return sum;
    }
}