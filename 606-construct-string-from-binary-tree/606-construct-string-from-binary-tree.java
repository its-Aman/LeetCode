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
    public String tree2str(TreeNode root) {
        if(root == null)
            return "";
        
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> seen = new HashSet<>();
        
        stack.push(root);
        
        while(!stack.isEmpty()) {
            var curr = stack.peek();
            
            if(seen.contains(curr)) {
                stack.pop();
                sb.append(")");
            } else {
                seen.add(curr);
                sb.append("(" + curr.val);
                
                if(curr.left == null && curr.right != null)
                    sb.append("()");

                if(curr.right != null)
                    stack.push(curr.right);

                if(curr.left != null)
                    stack.push(curr.left);
                
            }
        }
        
        return sb.substring(1, sb.length() - 1);
    }
}