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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        Deque<Pair<TreeNode, Integer>> dq = new ArrayDeque<>();
        int ans = 1;
        
        dq.offer(new Pair<>(root, 0));
        
        while(!dq.isEmpty()) {
            int size = dq.size();
            int start = dq.peekFirst().getValue();
            int end = dq.peekLast().getValue();
            
            ans = Math.max(ans, end - start + 1);
            
            while(size-- > 0) {
                var currP = dq.pollFirst();
                var curr = currP.getKey();
                int idx = currP.getValue() - start;
                
                if(curr.left != null)
                    dq.offerLast(new Pair<>(curr.left, 2 * idx + 1));
                
                if(curr.right != null)
                    dq.offerLast(new Pair<>(curr.right, 2 * idx + 2));
            }
        }
        
        return ans;
    }
}