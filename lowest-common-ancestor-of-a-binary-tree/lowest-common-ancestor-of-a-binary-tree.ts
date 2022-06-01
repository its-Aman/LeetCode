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

// DFS Recursive approach

function lowestCommonAncestor(root: TreeNode | null, p: TreeNode | null, q: TreeNode | null): TreeNode | null {
	let ans = null;

  dfs(root);
  
  return ans;

  function dfs(root: TreeNode | null): boolean {
    if(!root)
      return false;

    const left = dfs(root.left) ? 1 : 0;
    const right = dfs(root.right) ? 1 : 0;
    const mid = (root == p || root == q) ? 1 : 0;

    if(left + right + mid >= 2)
      ans = root;
    
    return (left + right + mid > 0);
  }
}