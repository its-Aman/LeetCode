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

function isSubtree_rec(root: TreeNode | null, subRoot: TreeNode | null): boolean {
  if(isEqual(root, subRoot))
    return true;

  if(!root)
    return false;
  
  return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

  function isEqual(root1: TreeNode | null, root2: TreeNode | null): boolean {
    if(!root1 || !root2)
      return root1 == root2;

    return (root1.val == root2.val) && isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
  }
};

function isSubtree(root: TreeNode | null, subRoot: TreeNode | null): boolean {
  const s = serialize(root),
        p = serialize(subRoot);

  return kmp(s, p);
}

function serialize(root: TreeNode | null): string {
  if(!root)
    return ',#';
  else
    return ''.concat(',', root.val.toString(), serialize(root.left), serialize(root.right));
}

function kmp(s: string, p: string): boolean {
  const lps = buildLPS(p),
        N = s.length, 
        M = p.length;
  
  for(let i = 0, j = 0; i < N; i++) {
    while(j > 0 && s.at(i) != p.at(j))
      j = lps[j - 1];
    
    if(s.at(i) == p.at(j))
      j++;
    
    if(j == M)
      return true;
  }
  
  return false;
}

function buildLPS(p: string): Array<number> {
  const N = p.length,
        lps = new Array<number>(N).fill(0);
  
  for(let j = 0, i = 1; i < N; i++) {
    
    while(j > 0 && p.at(i) != p.at(j))
      j = lps[j - 1];
    
    if(p.at(i) == p.at(j))
        lps[i] = ++j;
  }
  
  return lps;
}