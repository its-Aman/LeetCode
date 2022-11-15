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
        if(root == null)
            return 0;
        int leftDepth = 1, rightDepth = 1;
        
        TreeNode left = root.left;
        
        while(left != null) {
            leftDepth++;
            left = left.left;
        }

        TreeNode right = root.right;
        
        while(right != null) {
            rightDepth++;
            right = right.right;
        }
        
        if(leftDepth == rightDepth)
            return (int)Math.pow(2, leftDepth) - 1;
        
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    public int countNodes2(TreeNode root) {
        int cnt = 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            while(size-- > 0) {
                TreeNode curr = q.poll();
                
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