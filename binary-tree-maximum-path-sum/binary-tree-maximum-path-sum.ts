/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function maxPathSum(root: TreeNode | null): number {
  let maxSum = Number.MIN_SAFE_INTEGER;
  dfs(root);
  return maxSum;
  
  function dfs(root: TreeNode | null): number {
    if(!root)
      return 0;

    const leftMax = dfs(root.left),
          rightMax = dfs(root.right),
          maxRightLeft = Math.max(rightMax, leftMax),
          maxOneNodeRoot = Math.max(root.val, root.val + maxRightLeft),
          maxAll = Math.max(maxOneNodeRoot, leftMax + root.val + rightMax);
    maxSum = Math.max(maxSum, maxAll);
    return maxOneNodeRoot;
  }

};
