class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0, minmax = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            minmax = Math.max((sum + i) / (i + 1), minmax);
        }
        
        return (int)minmax;
    }
}