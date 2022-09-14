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
        
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null)
            return ans;
        
        q.offer(root);
        
        while(!q.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            int size = q.size();
            
            while(size-- > 0) {
                TreeNode node = q.poll();
                curr.add(node.val);
                
                if(node.left != null)
                    q.offer(node.left);

                if(node.right != null)
                    q.offer(node.right);
            }

            if(level % 2 == 1)
                Collections.reverse(curr);

            ans.add(curr);
            ++level;
        }
        
        return ans;
    }
}