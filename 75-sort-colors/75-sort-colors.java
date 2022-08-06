class Solution {
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void sortColors(int[] nums) {
        int lo = 0;
        int mid = 0;
        int hi = nums.length - 1;

        while(mid <= hi) {
            if(nums[mid] == 0) {
                this.swap(nums, lo, mid);
                lo += 1;
                mid += 1;
            } else if(nums[mid] == 1) {
                mid += 1;
            } else {
                this.swap(nums, mid, hi);
                hi -= 1;
            }
        }
    }
}