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

function levelOrder(root: TreeNode | null): number[][] {
  
  if(!root)
    return [];
  
  const level_order_traversal = new Array<Array<number>>();
  let q = new Array<TreeNode>();
  
  q.push(root);
  
  while(q.length) {
    const curr_q = new Array<TreeNode>(),
          curr_level = new Array<number>();
    
    for(let i = 0; i < q.length; i++) {
      const curr_item = q[i];

      curr_level.push(curr_item.val);

      if(curr_item.left)
        curr_q.push(curr_item.left)

      if(curr_item.right)
        curr_q.push(curr_item.right);
    }
    
    level_order_traversal.push(curr_level);
    q = curr_q;
  }
  
  return level_order_traversal;
};