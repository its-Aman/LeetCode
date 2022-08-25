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
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        this.go(root, targetSum, new ArrayList<>());
        
        return this.ans;
    }
    
    private void go(TreeNode curr, int sum, List<Integer> list) {
        
        if(curr == null)
            return;
        
        list.add(curr.val);
        sum -= curr.val;
        
        if(sum == 0 && curr.left == null && curr.right == null){
            this.ans.add(list);
            return;   
        }
        
        this.go(curr.left, sum, new ArrayList<>(list));
        this.go(curr.right, sum, new ArrayList<>(list));        
    }
}