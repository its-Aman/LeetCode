class Solution {
   public int maxDivScore(int[] nums, int[] divisors) {
        Arrays.sort(divisors);
        int ans = divisors[0];

        for (int i = 0, max = 0, cnt = 0; i < divisors.length; i++, cnt = 0) {
            for (int num : nums) {
                if (num % divisors[i] == 0) {
                    cnt++;
                }
            }

            if (cnt > max) {
                max = cnt;
                ans = divisors[i];
            }
        }

        return ans;
    }
}