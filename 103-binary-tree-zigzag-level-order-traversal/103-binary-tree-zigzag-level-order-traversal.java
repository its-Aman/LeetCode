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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        boolean left2right = true;
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        
        if(root == null)
            return ans;
        
        q.offer(root);
        
        while(!q.isEmpty()) {
            LinkedList<Integer> curr = new LinkedList<>();
            int size = q.size();
            
            while(size-- > 0) {
                TreeNode node = q.poll();
                
                if(left2right)
                    curr.addLast(node.val);
                else
                    curr.addFirst(node.val);                    
                
                if(node.left != null)
                    q.offer(node.left);

                if(node.right != null)
                    q.offer(node.right);
            }

            ans.add(curr);
            left2right = !left2right;
        }
        
        return ans;
    }
}