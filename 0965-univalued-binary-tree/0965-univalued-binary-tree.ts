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

// written by chatGPT
function isUnivalTree(root: TreeNode | null): boolean {
    if (root === null) {
        return true; // an empty tree is considered uni-valued
    }

    const value = root.val;
    return isUnivalTreeHelper(root, value);
}

function isUnivalTreeHelper(node: TreeNode | null, value: number): boolean {
    if (node === null) {
        return true; // an empty subtree is considered uni-valued
    }

    if (node.val !== value) {
        return false; // if the current node's value is different from the given value, then the subtree is not uni-valued
    }

    // recursively check if the left and right subtrees are uni-valued with the given value
    return isUnivalTreeHelper(node.left, value) && isUnivalTreeHelper(node.right, value);
}
