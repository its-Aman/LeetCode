class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      int N = nums.length;
      List<List<Integer>> ans = new LinkedList<>();

      if(N < 3) {
        return ans;
      }

      Arrays.sort(nums);

      for(int i = 0; i < N - 2; ++i) {
        int a = nums[i];

        if(a > 0)
          return ans;

        if(i > 0 && a == nums[i - 1])
          continue;

        for(int j = i + 1, k = N - 1; j < k;) {
          int b = nums[j];
          int c = nums[k];
          int result = a + b + c;

          if(result == 0) {
            ans.add(Arrays.asList(a, b, c));
            ++j;
            --k;

          while(j < k && nums[j] == nums[j - 1])
            ++j;

          while(j < k && nums[k] == nums[k + 1])
            --k;
          } else if(result > 0) {
            --k;
          } else {
            ++j;
          }
        }
      }

      return ans;      
    }
}