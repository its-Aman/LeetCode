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
  let maxDia = 0;
  
  findDia(root);
  
  return maxDia
  
  
  function findDia(root: TreeNode | null): number {
    if(!root)
      return 0;

    const lDia = findDia(root.left),
          rDia = findDia(root.right),
          dia = lDia + rDia;
    
    maxDia = Math.max(maxDia, dia);
    
    return 1 + Math.max(lDia, rDia);
  }
}