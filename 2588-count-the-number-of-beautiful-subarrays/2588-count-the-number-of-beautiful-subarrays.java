class Solution {
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        int pre = 0;
        long ans = 0;

        for (int num : nums) {
            pre ^= num;
            int val = dp.getOrDefault(pre, 0);
            ans += val;
            dp.put(pre, val + 1);
        }
        
        return ans;
    }
}