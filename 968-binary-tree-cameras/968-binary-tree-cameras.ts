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

// https://leetcode.com/problems/binary-tree-cameras/solution/770395

function minCameraCover(root: TreeNode | null): number {
  enum Camera {
    HAS_CAMERA,
    COVERED,
    PLEASE_COVER
  };
  
  let cameraCount = 0,
      state = getState(root);
  
  if(state == Camera.PLEASE_COVER)
    cameraCount++;
  
  return cameraCount;
  
  function getState(node: TreeNode): Camera {
    if(!node)
      return Camera.COVERED;
    
    const l = getState(node.left),
          r = getState(node.right);
    
    if([l, r].includes(Camera.PLEASE_COVER)){
      cameraCount++;
      return Camera.HAS_CAMERA;
    }

    if([l, r].includes(Camera.HAS_CAMERA))
      return Camera.COVERED;
    
    return Camera.PLEASE_COVER;

  }
}

function minCameraCover_sol(root: TreeNode | null): number {
  const cameraInstalledOn = new Set<TreeNode>();
  let cameraCount = 0;
  
  cameraInstalledOn.add(null);
  dfs(root, null);
  return cameraCount;
  
  function dfs(node: TreeNode, parent: TreeNode): void {
    if(!node)
      return;
    
    dfs(node.left, node);
    dfs(node.right, node);

    if(!parent && 
      !cameraInstalledOn.has(node) ||
      !cameraInstalledOn.has(node.left) || 
      !cameraInstalledOn.has(node.right)
    ) {
      cameraCount++;
      cameraInstalledOn.add(parent);
      cameraInstalledOn.add(node);
      cameraInstalledOn.add(node.left);
      cameraInstalledOn.add(node.right);
    }
  }
};