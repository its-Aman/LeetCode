class Solution {
    public int arithmeticTriplets(int[] nums, int D) {
        boolean[] cnt = new boolean[201];
        int ans = 0;
        
        for(int num: nums) {
            if(num >= 2 * D)
                ans += cnt[num - D] && cnt[num - 2 * D] ? 1 : 0;
            cnt[num] = true;
        }
        
        return ans;
    }
}