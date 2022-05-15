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

/*
Naive way of doing traversal.

function deepestLeavesSum(root: TreeNode | null): number {
  let head: TreeNode | null = root,
      depth: number = 0,
      sum: {total: number} = {total: 0};

  depth = traverse(head);
  head = root;
  
  findDeepestSum(head, depth, sum);  
  return sum.total;
};

function findDeepestSum(root: TreeNode | null, maxDepth: number, sum: {total: number}): number {
  if(!root)
    return;
  
  if(root.left || root.right){    
      findDeepestSum(root.left, maxDepth - 1, sum); 
      findDeepestSum(root.right, maxDepth - 1, sum)
  }

  if(maxDepth == 0)
    sum.total += root.val;
}

function traverse(root: TreeNode | null, depth = 0): number {
  if(!root)
    return depth;
  
  if(root.left || root.right)
    return Math.max(traverse(root.left, depth + 1), traverse(root.right, depth + 1));

  return depth;
}

*/

function deepestLeavesSum(root: TreeNode | null): number {
  let q = [root],
      output = 0;
  
  while(q.length){
    let newQ = [],
        sum = 0;
    
    for(let node of q){
      sum += node.val;
      if(node.left) newQ.push(node.left);
      if(node.right) newQ.push(node.right);
    }
    output = sum;
    q = newQ;
  }
  return output;
}