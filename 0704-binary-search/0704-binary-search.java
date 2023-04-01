class Solution {
    public int search(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(nums[m] == k) {
                return m;
            } else if(nums[m] < k) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        return -1;
    }
}