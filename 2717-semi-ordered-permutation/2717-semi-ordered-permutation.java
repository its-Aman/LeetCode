class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int N = nums.length;
        int x = -1, y = -1;

        for (int i = 0; i < N; i++) {
            if (nums[i] == 1) {
                x = i;
            }
            if (nums[i] == N) {
                y = i;
            }
        }
    
        return (x + (N-y-1) - (x>y ? 1 : 0));
    }}