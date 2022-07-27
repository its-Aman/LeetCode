class Solution {
    public int[] productExceptSelf(int[] nums) {
      int N = nums.length;
      int[] prefixProduct = new int[N];
      int[] postfixProduct = new int[N];
      int[] ans = new int[N];
      Arrays.fill(ans, 1);
      
      for(int i = 0; i < N; i++) {
        if(i == 0) {
          prefixProduct[i] = 1;
        } else {
          prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }
      }

      for(int i = N - 1; i >= 0; i--) {
        if(i == N - 1) {
          postfixProduct[i] = 1;
        } else {
          postfixProduct[i] = postfixProduct[i + 1] * nums[i + 1];          
        }
      }
      
      for(int i = 0; i < N; i++) {
        ans[i] = prefixProduct[i] * postfixProduct[i];
      }

      return ans;
    }
}