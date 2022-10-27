class Solution {
    int total = 0;
    
    public int findTargetSumWays(int[] nums, int target) {
        int N = nums.length;
        total = Arrays.stream(nums).sum();
        
        int[][] memo = new int[N][2*total+1];
        
        for(int[] row: memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        
        return backtrack(nums, target, 0, 0, memo);
    }
    
    private int backtrack(int[] nums, int target, int idx, int sum, int[][] memo) {
        if(idx == nums.length) {
            return (target == sum) ? 1 : 0;
        } else {
            if(memo[idx][sum+total] != Integer.MIN_VALUE)
                return memo[idx][sum+total];
            
            return memo[idx][sum+total] = backtrack(nums, target, idx + 1, sum + nums[idx], memo) + backtrack(nums, target, idx + 1, sum - nums[idx], memo);
        }
    }
}