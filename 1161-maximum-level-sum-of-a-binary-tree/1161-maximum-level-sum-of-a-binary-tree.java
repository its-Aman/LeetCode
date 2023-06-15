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
    public int maxLevelSum(TreeNode root) {
        int level = 0, maxSum = Integer.MIN_VALUE, ans=0; 
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            level++;
            
            while(size-- > 0) {
                var node = q.poll();
                sum += node.val;

                if(node.left != null) q.offer(node.left);

                if(node.right != null) q.offer(node.right);
            }
            
            if(maxSum < sum) {
                maxSum = sum;
                ans = level;
            }
        }
        
        return ans;
    }
}