class Solution {
    public int numberOfSubarrays(int[] nums, int K) {
        int ans = 0, count = 0, N = nums.length;

        for (int left = 0, right = 0; right < N; right++) {
            if (nums[right] % 2 == 1) {
                --K;
                count = 0;
            }

            while (K == 0) {
                K += nums[left++] % 2;
                ++count;
            }
            ans += count;
        }

        return ans;
    }
}

/*

[2,2,2,1,2,2,1,2,2,2]

2,2,2,1,2,2,1
2,2,1,2,2,1
2,1,2,2,1
1,2,2,1
1,2,2,1,2
1,2,2,1,2,2
1,2,2,1,2,2,2

2,2,2,1,2,2,1,2,2,2

2,2,1,2,2,1,2,2,2
2,1,2,2,1,2,2,2
2,2,2,1,2,2,1,2,2
2,2,2,1,2,2,1,2

2,1,2,2,1,2
2,1,2,2,1,2,2

2,2,1,2,2,1,2
2,2,1,2,2,1,2,2
*/