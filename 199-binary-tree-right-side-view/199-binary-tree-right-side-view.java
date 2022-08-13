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
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> dict = new HashMap<>();

        this.bfs(0, root, dict);
        
        return List.copyOf(dict.values());
    }
    
    private void bfs(int level, TreeNode root, Map<Integer, Integer> dict) {
        if(root == null)
            return;
        
        dict.put(level, root.val);
        this.bfs(level + 1, root.left, dict);
        this.bfs(level + 1, root.right, dict);
    }
}