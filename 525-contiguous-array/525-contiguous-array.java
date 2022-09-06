class Solution {
    public int findMaxLength(int[] nums) {
        int ans = 0, prefix = 0, N = nums.length;
        int[] map = new int[2*N + 1];
        Arrays.fill(map, -2);
        
        map[N] = -1;
        
        for(int i = 0; i < N; i++) {
            prefix += nums[i] == 0 ? -1 : 1;
            
            if(map[prefix + N] >= -1)
                ans = Math.max(ans, i - map[prefix + N]);
            else
                map[prefix + N] = i;
        }
        
        return ans;
    }
}