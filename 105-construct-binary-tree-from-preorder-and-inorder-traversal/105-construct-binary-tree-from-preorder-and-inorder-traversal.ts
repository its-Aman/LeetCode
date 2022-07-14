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

function buildTree(preorder: number[], inorder: number[]): TreeNode | null {
  const N = preorder.length,
        map = new Map<number, number>();
  let idx = 0;
  
  for(let i = 0; i < N; i++)
    map.set(inorder[i], i)
  
  return dfs(0, N - 1);
  
  function dfs(left: number, right: number): TreeNode | null {
    if(left > right)
      return null;

    const rootVal = preorder[idx++],
        i = map.get(rootVal);
    
    return new TreeNode(rootVal, dfs(left, i - 1), dfs(i + 1, right));
  }
};