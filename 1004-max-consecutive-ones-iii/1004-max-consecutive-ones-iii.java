class Solution {
    public int longestOnes(int[] nums, int K) {
        int N = nums.length, ans = 0;

        for (int left = 0, right = 0; right < N; right++) {
            K -= nums[right] == 0 ? 1 : 0;

            while (K < 0) 
                K += nums[left++] == 0 ? 1 : 0;
            
            ans = Math.max(ans, right - left + 1);

        }

        return ans;
    }
}