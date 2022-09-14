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

    Map<Long, Integer> preSum = new HashMap<>();

    public int pathSum(TreeNode root, int k) {
        preSum.put(0L, 1);

        return dfs(root, 0, k);
    }

    public int dfs(TreeNode node, long currSum, int k) {
        if (node == null)
            return 0;

        currSum += node.val;
        int res = preSum.getOrDefault(currSum - k, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += dfs(node.left, currSum, k) + dfs(node.right, currSum, k);
        preSum.put(currSum, preSum.get(currSum) - 1);

        return res;
    }

}