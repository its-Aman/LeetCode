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

function isBalanced(root: TreeNode | null): boolean {
  if(!root)
    return true;
  
  let ans = true;
  
  dfs(root);
  
  return ans;
  
  function dfs(root: TreeNode | null): number {
    if(!root)
      return 0;
    
    const l_ht = dfs(root.left),
          r_ht = dfs(root.right);
    
    ans &&= [-1, 0, 1].includes(l_ht - r_ht);
    
    return 1 + Math.max(l_ht, r_ht);
  }

};