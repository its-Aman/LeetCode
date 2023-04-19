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
    public int longestZigZag(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        return Math.max(longestZigZag(root, true, 0), longestZigZag(root, false, 0));
    }

    private int longestZigZag(TreeNode root, boolean goLeft, int cnt) {
        if(root == null) {
            return cnt - 1;
        }
        
        if(goLeft) {
             return Math.max(longestZigZag(root.left, false, cnt+1), longestZigZag(root.right, true, 1));
        } else {
             return Math.max(longestZigZag(root.right, true, cnt+1), longestZigZag(root.left, false, 1));
        }
    }
}