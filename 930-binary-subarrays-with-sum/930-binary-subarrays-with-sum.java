class Solution {
    public int numSubarraysWithSum(int[] nums, int K) {
        return numSubarraysWithSum_Arr(nums, K);
        // return numSubarraysWithSum_3Pointer(nums, K);
    }

    public int numSubarraysWithSum_3Pointer(int[] nums, int K) {
        int N = nums.length, ans = 0;
        int iLo = 0, iHi = 0;
        int sumLo = 0, sumHi = 0;

        for (int i = 0; i < N; i++) {
            sumLo += nums[i];
            while (iLo < i && sumLo > K)
                sumLo -= nums[iLo++];

            sumHi += nums[i];
            while (iHi < i && (sumHi > K || sumHi == K && nums[iHi] == 0))
                sumHi -= nums[iHi++];

            if (sumLo == K)
                ans += iHi - iLo + 1;
        }

        return ans;
    }

    public int numSubarraysWithSum_Arr(int[] nums, int K) {
        int N = nums.length, sum = 0, ans = 0;
        int[] count = new int[N + 1];

        count[0] = 1;

        for (int num : nums) {
            sum += num;
            if (sum - K >= 0)
                ans += count[sum - K];
            count[sum] += 1;
        }

        return ans;
    }
}