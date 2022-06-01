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
// DFS Recursive approach

function lowestCommonAncestor(root: TreeNode | null, p: TreeNode | null, q: TreeNode | null): TreeNode | null {
	let ans = null;

  dfs(root);
  
  return ans;

  function dfs(root: TreeNode | null): boolean {
    if(!root)
      return false;

    const left = dfs(root.left) ? 1 : 0;
    const right = dfs(root.right) ? 1 : 0;
    const mid = (root == p || root == q) ? 1 : 0;

    if(left + right + mid >= 2)
      ans = root;
    
    return (left + right + mid > 0);
  }
}

*/


/*
// Iterative using parent pointer.

function lowestCommonAncestor(root: TreeNode | null, p: TreeNode | null, q: TreeNode | null): TreeNode | null {
  const stack = [], // stack for tree traversal
        parent = new Map<TreeNode, TreeNode>(), // map for parent pointers
        ancestors = new Set<TreeNode>(); // ancestors set for node p
  
  parent.set(root, null); // currentNode, parentNode
  stack.push(root); // a kind of dfs call
  
//   Lets track all the parents until we find p or q
  while(!parent.has(p) || !parent.has(q)){
    const node = stack.pop();
    
//     keep saving the parents of current nodes.
    if(node.right){
      parent.set(node.right, node);
      stack.push(node.right);
    }

    if(node.left){
      parent.set(node.left, node);
      stack.push(node.left);
    }
  }
  
//   here is the main part, we'll now be processing ancestors of p and keeping them safe in a set.
  while(p){
    ancestors.add(p);
    p = parent.get(p);
  }
  
//   now we just iterate over ancestors set to find the parent of both p and q
  while(!ancestors.has(q))
    q = parent.get(q);
  
  return q;
}
*/

// Iterative without parent pointer.

function lowestCommonAncestor(root: TreeNode | null, p: TreeNode | null, q: TreeNode | null): TreeNode | null {
  const STATE = {
    BOTH_PENDING: 2, // both the left and right subtree are pending for processing
    LEFT_DONE: 1, // left tree is done and right subtree is pending for processing
    BOTH_DONE: 0 // both the left and right subtree are done processing
  },
        stack = [];
  
  stack.push([root, STATE.BOTH_PENDING]);
  
  let one_node_found = false,
      LCA = null,
      child_node = null;
  
  while(stack.length){
    const [parent_node, parent_state] = stack[stack.length - 1];
    
    if(parent_state != STATE.BOTH_DONE){
      
      if(parent_state == STATE.BOTH_PENDING){
        
        if([p, q].includes(parent_node)){
          if(one_node_found){
            return LCA;            
          } else {
            one_node_found = true;
            LCA = parent_node;
          }
        }
        child_node = parent_node.left;
      } else {
        child_node = parent_node.right;
      }
    
      stack.pop();
      stack.push([parent_node, parent_state - 1]);
    
      if(child_node)
        stack.push([child_node, STATE.BOTH_PENDING]);
    } else {
      if(LCA == stack.pop()[0] && one_node_found)
        LCA = stack[stack.length - 1][0];
    }
  }

  return null;
}