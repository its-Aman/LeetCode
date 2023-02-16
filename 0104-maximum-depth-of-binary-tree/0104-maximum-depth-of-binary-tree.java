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
    public int maxDepth(TreeNode root) {
        int depth = 0;

        if(root == null) {
            return depth;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root); 
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0) {
                var curr = q.poll();

                if(curr.left != null) {
                    q.offer(curr.left);
                }

                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }
            
            depth++;
        }
        
        return depth;
    }
}