class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0, j = 0; i < nums1.length || j < nums2.length; ) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i][0] == nums2[j][0]) {
                    list.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                    i++;
                    j++;
                } else if (nums1[i][0] < nums2[j][0]) {
                    list.add(nums1[i]);
                    i++;
                } else {
                    list.add(nums2[j]);
                    j++;
                }
            } else if (i < nums1.length) {
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[j]);
                j++;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    public int[][] mergeArrays2(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] ints : nums1) {
            map.put(ints[0], ints[1]);
        }

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i][0], map.getOrDefault(nums2[i][0], 0) + nums2[i][1]);
        }

        int idx = 0, M = map.size();
        int[][] ans = new int[M][2];

        for (var k : map.keySet()) {
            ans[idx++] = new int[]{k, map.get(k)};
        }

        return ans;
    }
}