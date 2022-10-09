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
    public boolean findTarget(TreeNode root, int k) {
        if(k == 0)
            return true;

        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        // set.add(k);
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            while(size-- > 0) {
                TreeNode curr = q.poll();
                
                if(set.contains(k - curr.val))
                    return true;
                
                if(curr.left != null)
                    q.offer(curr.left);

                if(curr.right != null)
                    q.offer(curr.right);
                
                set.add(curr.val);
            }
        }
        
        return false;
    }
}