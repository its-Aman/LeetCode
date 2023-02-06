class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int N = nums.length;
        int[] map = new int[1000006];
        
        for(int i = 0; i < N; i++) {
            map[nums[i]] = i;
        }
        
        for(int[] ops: operations) {
            int idx = map[ops[0]];
            map[ops[1]] = idx;
            nums[idx] = ops[1];
        }
        
        return nums;
    }
}