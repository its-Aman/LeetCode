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

function isSymmetric(root: TreeNode | null): boolean {

    return isMirror(root.left, root.right);

    function isMirror(left: TreeNode | null | undefined, right: TreeNode | null | undefined): boolean {
        if (!left && !right)
            return true;

        if (left?.val != right?.val)
            return false;

        return isMirror(left?.left, right?.right) && isMirror(left?.right, right?.left);
    }

};