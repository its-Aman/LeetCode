class Solution {
    public void rotate(int[] nums, int K) {
        int N = nums.length;
        K %= N;
        
        this.rotate(nums, 0, N - 1);
        this.rotate(nums, 0, K - 1);
        this.rotate(nums, K, N - 1);
    }
    
    private void rotate(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}