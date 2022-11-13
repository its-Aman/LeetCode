class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        int N = nums.length;

        for (int i = 0; i < N; i++) {
            int l = 1;
            for (int j = i; j < N; j++) {
                l = lcm(l, nums[j]);
                if (l == k)
                    ans++;

                if (l > k)
                    break;
            }
        }

        return ans;
    }

    private int lcm(int i, int j) {
        return (i * j) / gcd(i, j);
    }

    private int gcd(int i, int j) {
        return (j == 0) ? i : gcd(j, i % j);
    }
}