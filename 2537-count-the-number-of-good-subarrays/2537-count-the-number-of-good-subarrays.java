class Solution {
    public long countGood(int[] nums, int k) {
        int N = nums.length,
            left = 0,
            pairs = 0;
        long ans = 0;
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int right = 0; right < N; right++) {
            int rCnt = count.getOrDefault(nums[right], 0);
            pairs += rCnt;
            count.put(nums[right], rCnt + 1);
            
            while(pairs >= k) {
                int lCnt = count.get(nums[left]);
                count.put(nums[left], lCnt - 1);
                pairs -= lCnt - 1;
                left++;
            }
            
            ans += left;
        }
        
        return ans;
    }
}