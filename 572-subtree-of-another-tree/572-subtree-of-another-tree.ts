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

function isSubtree(root: TreeNode | null, subRoot: TreeNode | null): boolean {
  if(isEqual(root, subRoot))
    return true;

  if(!root)
    return false;
  
  return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

};

function isEqual(root1: TreeNode | null, root2: TreeNode | null): boolean {
  if(!root1 || !root2)
    return root1 == root2;

  return (root1.val == root2.val) && isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
}