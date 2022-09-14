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
    private int ans = 0;

    public int pseudoPalindromicPaths (TreeNode root) {
        int[] count = new int[10];
        ++count[root.val];
        
        findPath(root, count, 1);
        
        return ans;
    }
    
    private void findPath(TreeNode node, int[] count, int size) {
        if(node.left == null && node.right == null) {
            checkIfPseudoPalindrome(count, size);
            return;
        }
        
        if(node.left != null) {
            int[] lCount = count.clone();        
            ++lCount[node.left.val];
            findPath(node.left, lCount, size + 1);
        }

        if(node.right != null) {
            int[] rCount = count.clone();        
            ++rCount[node.right.val];
            findPath(node.right, rCount, size + 1);
        }       
    }
    
    private void checkIfPseudoPalindrome(int[] cnt, int size) {
        boolean isPali = true;
        
        if(size % 2 == 0) {
            // check for even palindrome
            for(int occ: cnt) {
                if(occ % 2 == 1) {
                    isPali = false;
                    break;
                }    
            }
        } else {
            // check for odd palindrome
            boolean allowOne = true;
            
            for(int occ: cnt) {
                if(occ % 2 == 1) {
                    if(allowOne) {
                        allowOne = false;
                    } else {                        
                        isPali = false;
                        break;
                    }
                }    
            }
        }
        
        if(isPali)
            ++ans;
    }
}