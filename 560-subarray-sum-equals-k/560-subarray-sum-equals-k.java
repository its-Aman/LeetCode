class Solution {
    
    public int subarraySum(int[] nums, int K) {
        int prefix = 0, ans = 0;
        Map<Integer, Integer> sumOcc = new HashMap<>();
        
        sumOcc.put(0, 1);

        for (int num : nums) {
            prefix += num;
            ans += sumOcc.getOrDefault(prefix - K, 0);
            sumOcc.put(prefix, 1 + sumOcc.getOrDefault(prefix, 0));
        }
        
        return ans;
    }
}