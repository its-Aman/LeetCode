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

function lowestCommonAncestor(root: TreeNode | null, p: TreeNode | null, q: TreeNode | null): TreeNode | null {
  let parent_p = p,
      parent_q = q;
  
  if(hasChild(parent_p, q))
    return parent_p;

  if(hasChild(parent_q, p))
    return parent_q;

  let curr = root;

  while(hasChild(curr, p) && hasChild(curr, q)) {
    if(hasChild(curr.left, p) && hasChild(curr.left, q))
      curr = curr.left;
    else if(hasChild(curr.right, p) && hasChild(curr.right, q))
      curr = curr.right;
    else
      break;
  }
  
  return curr;
  
  function hasChild(parent: TreeNode | null, child: TreeNode | null): boolean {
    if(!parent)
      return false;
    
    if(parent == child)
      return true;
    
    return (hasChild(parent.left, child) || hasChild(parent.right, child));
  }
};