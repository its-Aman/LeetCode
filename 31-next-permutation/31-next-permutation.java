class Solution {
    public void nextPermutation(int[] nums) {
        int N = nums.length;
        int i = N - 2;
        
        while(i >= 0 && nums[i + 1] <= nums[i])
            i--;
        
        if(i >= 0) {
            int j = N - 1;    
            
            while(nums[j] <= nums[i])
                j--;
            
            this.swap(nums, i, j);
        }
        
        this.reverse(nums, i + 1);
    }
    
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        
        while(start < end)
            this.swap(nums, start++, end--);
    }
    
    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}