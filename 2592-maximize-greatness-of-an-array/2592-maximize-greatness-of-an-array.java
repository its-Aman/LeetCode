class Solution {
    public int maximizeGreatness(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);

        for (int num : nums) {
            if(num > nums[ans]) {
                ans++;
            }
        }

        return ans;
    }
}