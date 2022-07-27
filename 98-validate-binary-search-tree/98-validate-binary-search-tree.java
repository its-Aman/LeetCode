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
  
    public boolean isValidBST(TreeNode root) {
      if(root == null || (root.left == null && root.right == null))
        return true;
      
      return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean isValidBST(TreeNode node, Double low, Double high) {
      if(node == null)
        return true;

      if(low >= node.val || high <= node.val)
        return false;
      
      return isValidBST(node.left, low, new Double(node.val)) && isValidBST(node.right, new Double(node.val), high);
    }
}

/*
--------------------
5
-2147483648
2147483647
--------------------
4
-2147483648
5
--------------------
--------------------
--------------------
6
5
2147483647
--------------------
3
5
6

*/