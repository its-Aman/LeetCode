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

function sortedArrayToBST(nums: number[]): TreeNode | null {
  const N = nums.length;
  
  if(N <= 0)
   return null;
  
  const half = N >>> 1;
  return new TreeNode(nums[half], sortedArrayToBST(nums.slice(0, half)), sortedArrayToBST(nums.slice(1 + half)));
};