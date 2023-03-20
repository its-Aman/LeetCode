class Solution {
    int ans = 0;
    
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        backtrack(new HashSet<>(), 0, nums, k);
        return ans - 1;
    }
    
    private void backtrack(Set<Integer> set, int i, int[] nums, int k) {
        ans++;
        
        for(int j = i; j < nums.length; j++) {
            if(!set.contains(nums[j] - k)) {
                set.add(nums[j]);
                backtrack(set, j + 1, nums, k);
                set.remove(nums[j]);
            }
        }
    }
}