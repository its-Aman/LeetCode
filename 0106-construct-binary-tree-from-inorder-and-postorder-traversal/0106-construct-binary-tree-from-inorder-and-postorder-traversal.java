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
    Map<Integer, Integer> map = new HashMap<>();
    int pEnd;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int N = inorder.length;
        pEnd = N - 1;
        
        for(int i = 0; i < N; i++) {
            map.put(inorder[i], i);
        }
        
        return buildTree(inorder, postorder, 0, N - 1);
    }
    
    private TreeNode buildTree(int[] inorder, int[] postorder, int iStart, int iEnd) {
        if(iStart > iEnd) {
            return null;
        }
        
        int iIdx = map.get(postorder[pEnd]);
        TreeNode node = new TreeNode(postorder[pEnd]);
        pEnd--;
        
        node.right = buildTree(inorder, postorder, iIdx + 1, iEnd);
        node.left = buildTree(inorder, postorder, iStart, iIdx - 1);

        return node;
    }
}