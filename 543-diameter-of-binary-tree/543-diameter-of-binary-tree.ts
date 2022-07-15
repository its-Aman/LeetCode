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
function diameterOfBinaryTree(root: TreeNode | null): number {
  if(!root)
    return 0;
  
  const dia = depth(root.left) + depth(root.right),
        lDia = diameterOfBinaryTree(root.left),
        rDia = diameterOfBinaryTree(root.right);
  
  return Math.max(dia, Math.max(lDia, rDia));
  
  function depth(root: TreeNode | null): number {
    if(!root)
      return 0;

    return 1 + Math.max(depth(root.left), depth(root.right));
  }
}