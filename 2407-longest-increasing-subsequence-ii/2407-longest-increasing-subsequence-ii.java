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

    class SegmentTree {
        int N = (int) 1e5 + 1;
        int[] tree = new int[2 * N];

        public int query(int l, int r) {
            l += N;
            r += N;
            int ans = 0;

            while (l < r) {
                if ((l & 1) >= 1)
                    ans = Math.max(ans, tree[l++]);

                if ((r & 1) >= 1)
                    ans = Math.max(ans, tree[--r]);
                l >>= 1;
                r >>= 1;
            }

            return ans;
        }

        public void update(int idx, int val) {
            idx += N;
            tree[idx] = val;
            while (idx > 1) {
                idx >>= 1;
                tree[idx] = Math.max(tree[idx * 2], tree[idx * 2 + 1]);
            }
        }
    }
}