class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int N = nums.length, 
            ans = 0, 
            prefixSum = 0;
        int[] freq = new int[k];
        
        freq[0] = 1;
        
        for(int i = 0; i < N; i++) {
            prefixSum  = (prefixSum + (nums[i] % k) + k) % k;
            ans += freq[prefixSum];
            freq[prefixSum]++;
            // System.out.printf("%d\t%d\t%d\t%s\n", ans, prefixSum, nums[i], Arrays.toString(freq));
        }
        
        return ans;
    }
}