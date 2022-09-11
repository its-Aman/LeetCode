class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int ans = 1;
        SegmentTree seg = new SegmentTree();

        for (int num : nums) {
            --num;
            int preMax = seg.query(Math.max(0, num - k), num);
            ans = Math.max(ans, preMax + 1);
            seg.update(num, preMax + 1);
        }

        return ans;
    }

    // https://codeforces.com/blog/entry/18051
    class SegmentTree {
        int N = (int) 1e5 + 1;
        int[] tree = new int[2 * N];

        public int query(int l, int r) {
            int ans = 0;

            for (l += N, r += N; l < r; l >>= 1, r >>= 1) {
                if ((l & 1) >= 1) ans = Math.max(ans, tree[l++]);
                if ((r & 1) >= 1) ans = Math.max(ans, tree[--r]);
            }

            return ans;
        }

        public void update(int idx, int val) {
            for (tree[idx += N] = val; idx > 1; idx >>= 1)
                tree[idx >> 1] = Math.max(tree[idx], tree[idx ^ 1]);
        }
    }
}