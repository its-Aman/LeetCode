class Solution {
    public int longestArithSeqLength(int[] nums) {
        int N = nums.length, ans = 0;
        HashMap<Integer, Integer>[] dp = new HashMap[N];
       
        for(int right=0; right<N; right++) {
            dp[right] = new HashMap<>();
            
            for(int left=0; left<right; left++) {
                int diff = nums[left] - nums[right];
                dp[right].put(diff, dp[left].getOrDefault(diff, 1)+1);
                ans = Math.max(ans, dp[right].get(diff));
            }
        }
        
        return ans;
    }
}