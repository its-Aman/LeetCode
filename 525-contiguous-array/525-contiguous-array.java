class Solution {
    public int findMaxLength(int[] nums) {
        int ans = 0, prefix = 0, N = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, -1);
        
        for(int i = 0; i < N; i++) {
            prefix += nums[i] == 0 ? -1 : 1;
            
            if(map.containsKey(prefix))
                ans = Math.max(ans, i - map.get(prefix));
            else
                map.put(prefix, i);
        }
        
        return ans;
    }
}