class Solution {

    public int[] productExceptSelf(int[] nums) {
      int N = nums.length;
      int[] ans = new int[N];

      Arrays.fill(ans, 1);

      for(int i = 0, left = 1, right = 1; i < N; i++) {
        ans[i] *= left;
        left *= nums[i];

        ans[N - 1 - i] *= right;
        right *= nums[N - 1 - i];
      }

      return ans;
    }
}