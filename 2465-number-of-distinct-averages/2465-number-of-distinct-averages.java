class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> uniq = new HashSet<>();

        int i = 0, j = nums.length - 1;

        while (i < j)
            uniq.add((nums[i++] + nums[j--]) / 2.0);

        return uniq.size();
    }
}