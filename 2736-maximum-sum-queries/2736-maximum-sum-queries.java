class Solution {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int[] ans = new int[queries.length];
        TreeMap<Integer, TreeSet<Integer>> sumToNum1 = new TreeMap<>();

        for (int i = 0; i < nums1.length; i++) {
            sumToNum1.computeIfAbsent(nums1[i] + nums2[i], k -> new TreeSet<>()).add(nums1[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            ans[i] = getMax(sumToNum1, queries[i]);
        }

        return ans;
    }

    private int getMax(TreeMap<Integer, TreeSet<Integer>> treeMap, int[] q) {
        int x = q[0], y = q[1];
        Integer sum = treeMap.lastKey();
        while (sum != null) {
            var num1Set = treeMap.get(sum);
            Integer num1 = num1Set.last();
            while (num1 != null && num1 >= x) {
                if (sum - num1 >= y) return sum;
                num1 = num1Set.lower(num1);
            }
            sum = treeMap.lowerKey(sum);
        }
        return -1;
    }
}