class Solution {
    public int searchInsert(int[] nums, int k) {
        int l = 0, r = nums.length;
        
        while(l < r) {
            int m = l + ((r-l)>>1);
            
            if(nums[m] < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        return l;
    }
}