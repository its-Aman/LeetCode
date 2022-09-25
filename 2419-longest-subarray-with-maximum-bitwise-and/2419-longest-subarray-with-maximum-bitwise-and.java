class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, longest = 0, curr = 0;

        for (int num : nums) {
            if (num == max) {
                longest = Math.max(longest, ++curr);
            } else if (num > max) {
                max = num;
                curr = 1;
                longest = 1;
            } else {
                curr = 0;
            }
        }

        return longest;
    }
}