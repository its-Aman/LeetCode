class Solution {

    public int[] productExceptSelf(int[] nums) {
      int N = nums.length;
      int[] ans = new int[N];

      for(int i = 0, left = 1, right = 1; i < N; i++) {
        if(i < N / 2 + N % 2) {
          ans[i] = 1;
          ans[N - 1 - i] = 1;
        }
        
        ans[i] *= left;
        left *= nums[i];

        ans[N - 1 - i] *= right;
        right *= nums[N - 1 - i];
      }

      return ans;
    }
}