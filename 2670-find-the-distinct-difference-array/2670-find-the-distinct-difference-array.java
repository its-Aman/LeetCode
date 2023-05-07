class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(nums[i]);
            ans[i] = set.size();
        }
        
        set.clear();

        for (int i = N-1; i >= 0; i--) {
            ans[i] -= set.size();
            set.add(nums[i]);            
        }

        return ans;
    }
}