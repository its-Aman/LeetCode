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
    public int rob(TreeNode root) {
        var ans = dfs(root);
        int rob = ans[0], dontRob =  ans[1];
        
        return Math.max(rob, dontRob);
    }
    
    private int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[]{0, 0};
        }
        
        var left = dfs(root.left);
        var right = dfs(root.right);
        
        int leftDontRob = left[0], leftRob = left[1];
        int rightDontRob = right[0], rightRob = right[1];
        
        int currDontRob = Math.max(leftDontRob, leftRob) + Math.max(rightDontRob, rightRob);
        int currRob = root.val + leftDontRob + rightDontRob;
        
        return new int[] {currDontRob, currRob};
    }
}