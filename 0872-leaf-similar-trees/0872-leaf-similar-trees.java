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
    public boolean leafSimilar_2(TreeNode root1, TreeNode root2) {
        System.out.println(root1.val);
        System.out.println(root2.val);
        if(root1 == null && root2 == null)
            return true;

        if(root1 == null || root2 == null)
            return false;
        
        if(isLeaf(root1) && isLeaf(root2))
            return root1.val == root2.val;

        if(isLeaf(root1) || isLeaf(root2))
            return false;
        
        return leafSimilar(root1.left, root2.left) && leafSimilar(root1.right, root2.right);
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
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