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
  const set = new Set<string>();
  
  backtrack(root, []);

  return Array.from(set.values());

  function backtrack(root: TreeNode | null, curr: number[]) {

    if(root.left && !root.right) {
      curr.push(root.val);
      backtrack(root.left, curr);
      curr.pop();
    } else if(!root.left && root.right) {
      curr.push(root.val);
      backtrack(root.right, curr);
      curr.pop();
    } else if(root.left && root.right) {
      curr.push(root.val);
      backtrack(root.left, curr);
      backtrack(root.right, curr);
      curr.pop();
    } else {
      curr.push(root.val);
      set.add(curr.join('->'));
      curr.pop();
    }
  }
  
};