class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int start = 0, minStart = 0, maxStart = 0;
        boolean minFound = false, maxFound = false;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num < minK || num > maxK) {
                minFound = maxFound = false;
                start = i + 1;
            }

            if (num == minK) {
                minFound = true;
                minStart = i;
            }

            if (num == maxK) {
                maxFound = true;
                maxStart = i;
            }

            if (minFound && maxFound) 
                ans += Math.max(0l, Math.min(minStart, maxStart) - start + 1);
        }

        return ans;
    }
}