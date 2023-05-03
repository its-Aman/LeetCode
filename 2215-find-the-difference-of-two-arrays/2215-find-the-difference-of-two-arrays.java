class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(), ans1 = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int n2 : nums2) {
            set.add(n2);
        }

        for (int n1 : nums1) {
            if (!set.contains(n1)) {
                ans1.add(n1);
            }
        }

        ans.add(List.copyOf(ans1));
        ans1.clear();
        set.clear();

        for (int n1 : nums1) {
            set.add(n1);
        }

        for (int n2 : nums2) {
            if (!set.contains(n2)) {
                ans1.add(n2);
            }
        }

        ans.add(List.copyOf(ans1));
        return ans;
    }
}