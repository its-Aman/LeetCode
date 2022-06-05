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

function binaryTreePaths(root: TreeNode | null): string[] {
  const ans = []
  
  backtrack(root, []);

  return ans;

  function backtrack(root: TreeNode | null, curr: number[]) {
    curr.push(root.val);

    if(!root.left && !root.right){
      ans.push(curr.join('->'));
      return;
    }
    
    if(root.left) 
      backtrack(root.left, curr.slice(0));

    if(root.right) 
      backtrack(root.right, curr.slice(0));

  }
  
};