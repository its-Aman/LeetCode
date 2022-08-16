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
    private int k;
    private int ans = -1;
    
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        this.inorder(root);
        
        return this.ans;
    }
    
    private void inorder(TreeNode node) {
        if(node == null)
            return;
        
        this.inorder(node.left);
        
        if(--this.k == 0)
            this.ans = node.val;
        
        if(this.ans == -1)
            this.inorder(node.right);
    }
    
    public int kthSmallest_recursive(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        
        stack.push(root);
        
        while(true) {

            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            
            if(--k == 0)
                return root.val;
            
            root = root.right;
        }
    }
}