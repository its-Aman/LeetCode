/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        q.offer(root);
        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            list.clear();

            while (size-- > 0) {
                var curr = q.poll();
                list.add(new int[]{curr.val, list.size()});

                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
            ans += minSwaps(list);
        }

        return ans;
    }

    public int minSwaps(List<int[]> list) {
        int ans = 0;
        int N = list.size();
        boolean[] vis = new boolean[N];

        list.sort(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < N; i++) {

            if (vis[i] || list.get(i)[1] == i)
                continue;

            int cycle_size = 0;
            int j = i;
            
            while (!vis[j]) {
                vis[j] = true;
                j = list.get(j)[1];
                cycle_size++;
            }

            ans += Math.max(cycle_size - 1, 0);
        }

        return ans;
    }
}