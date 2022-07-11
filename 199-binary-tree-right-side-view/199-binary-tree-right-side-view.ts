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

function rightSideView(root: TreeNode | null): number[] {
  
  if(!root)
    return [];
  
  let Q = new Array(),
        ans = new Array();
  
  Q.push(root);
  
  while(Q.length) {
    let currQ = new Array();
    let j = 0;
    
    while(j < Q.length) {
      const curr = Q[j];
      j++;
      
      if(j == Q.length)
        ans.push(curr.val);
      
      if(curr.left)
        currQ.push(curr.left);

      if(curr.right)
        currQ.push(curr.right);
    }
    
    Q = currQ;
  }
  
  return ans;
};