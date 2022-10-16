class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = Integer.MIN_VALUE;

        for (var item : nums) {
            if (item < 0)
                set.add(item);
        }

        for (var item : nums) {
            if (item > 0 && set.contains(-item))
                ans = Math.max(ans, item);
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}