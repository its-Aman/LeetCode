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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>(), 
                        s2 = new Stack<>();
        s1.push(root1);
        s2.push(root2);
        
        while(!s1.isEmpty() && !s2.isEmpty())
            if(dfs(s1) != dfs(s2))
                return false;
        
        return s1.isEmpty() && s2.isEmpty();
    }
    
    private int dfs(Stack<TreeNode> s) {
        while(true) {
            var curr = s.pop();
            
            if(curr.right != null)
                s.push(curr.right);
            if(curr.left != null)
                s.push(curr.left);
            if(curr.left == null && curr.right == null)
                return curr.val;
        }
    }
    
    public boolean leafSimilar_2(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>(),
                        l2 = new ArrayList<>();
        
        getLeafs(root1, l1);
        getLeafs(root2, l2);
        
        if(l1.size() != l2.size())
            return false;
        
        for(int i = 0; i < l1.size(); i++)
            if(l1.get(i) != l2.get(i))
                return false;
        
        return true;

    }
    
    private void getLeafs(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        
        if(root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        
        getLeafs(root.left, list);
        getLeafs(root.right, list);
    }
}