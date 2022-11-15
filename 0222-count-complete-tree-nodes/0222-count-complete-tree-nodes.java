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
    public int countNodes(TreeNode root) {
        int cnt = 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            while(size-- > 0) {
                var curr = q.poll();
                
                if(curr == null)
                    continue;
                
                q.offer(curr.left);
                q.offer(curr.right);
                cnt += 1;
            }
        }
        
        
        return cnt;
    }
}