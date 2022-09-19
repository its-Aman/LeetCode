/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        setParents(root, parents);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(null);
        q.offer(target);

        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        seen.add(null);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                if (k == 0) {
                    while (!q.isEmpty())
                        ans.add(q.poll().val);
                    break;
                }
                q.offer(null);
                k--;
            } else {
                if (!seen.contains(curr.left)) {
                    seen.add(curr.left);
                    q.offer(curr.left);
                }
                if (!seen.contains(curr.right)) {
                    seen.add(curr.right);
                    q.offer(curr.right);
                }

                TreeNode parent = parents.get(curr);
                if (!seen.contains(parent)) {
                    seen.add(parent);
                    q.offer(parent);
                }
            }
        }

        return ans;
    }

    private void setParents(TreeNode root, Map<TreeNode, TreeNode> parents) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        parents.put(root, null);

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                TreeNode curr = q.poll();

                if (curr.left != null) {
                    q.offer(curr.left);
                    parents.put(curr.left, curr);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                    parents.put(curr.right, curr);
                }
            }
        }
    }
}