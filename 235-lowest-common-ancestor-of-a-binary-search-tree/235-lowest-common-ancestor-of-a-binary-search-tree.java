/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode P, TreeNode Q) {

        if(P.val > root.val && Q.val > root.val)
            return lowestCommonAncestor(root.right, P, Q);
        else if(P.val < root.val && Q.val < root.val)
            return lowestCommonAncestor(root.left, P, Q);
        else
            return root;
        
//         var curr = root;
        
//         while(true) {
//             if(P.val > curr.val && Q.val > curr.val)
//                 curr = curr.right;
//             else if(P.val < curr.val && Q.val < curr.val)
//                 curr = curr.left;
//             else
//                 break;
//         }
        
//         return curr;
        
//         if(root == null || root.val == P.val || root.val == Q.val)
//             return root;
        
        
//         var left = lowestCommonAncestor(root.left, P, Q);
//         var right = lowestCommonAncestor(root.right, P, Q);
        
//         if(left == null)
//             return right;
//         else if(right == null)
//             return left;
//         else 
//             return root;
    }
}