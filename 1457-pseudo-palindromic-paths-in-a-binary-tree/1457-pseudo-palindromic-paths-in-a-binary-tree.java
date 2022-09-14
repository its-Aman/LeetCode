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

    public int pseudoPalindromicPaths (TreeNode root) {
        findPath(root, 0);
        return ans;
    }
    
    private void findPath(TreeNode node, int mask) {
        if(node == null)
            return;
        
        mask ^= (1 << node.val);

        
        if(node.left == null && node.right == null) {
            System.out.println(mask);
            if(mask == 0 || (mask & (mask - 1)) == 0)
                ++ans;
            return;
        }
        
        findPath(node.left, mask);
        findPath(node.right, mask);
    }
}