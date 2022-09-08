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
    private List<Integer> ans;
    
    public List<Integer> inorderTraversal(TreeNode root) {
        this.ans = new ArrayList<>();
        
        this.inorder(root);
        
        return ans;
    }
    
    private void inorder(TreeNode curr){
        if(curr == null)
            return;
        
        inorder(curr.left);
        ans.add(curr.val);
        inorder(curr.right);
    }
}