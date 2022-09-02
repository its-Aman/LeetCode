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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            double total = 0d, divisor = q.size();
            
            while(size-- > 0) {
                TreeNode curr = q.poll();
                total += curr.val;
                
                if(curr.left != null)
                    q.offer(curr.left);

                if(curr.right != null)
                    q.offer(curr.right);
            }

            ans.add(total / divisor);
        }
        
        return ans;
    }
}