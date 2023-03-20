class Solution {
    int[] set = new int[1001];
    
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        return backtrack(0, nums, k) - 1;
    }
    
    private int backtrack(int i, int[] nums, int k) {
        
        if(i == nums.length) {
            return 1;
        }
        
        int take = 0;
        
        if(nums[i] - k < 0 || set[nums[i] - k] == 0) {
            set[nums[i]]++;
            take = backtrack(i + 1, nums, k);
            set[nums[i]]--;
        }
        
        int notTake = backtrack(i + 1, nums, k);
        
        return take + notTake;
    }
}