class Solution {
    Set<List<Integer>> ans = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        int N = nums.length;
        findSubsequences(new LinkedList<>(), nums, 0);
        return new ArrayList<>(ans);
    }

    public void findSubsequences(List<Integer> curr, int[] nums, int idx) {
        if (idx == nums.length) {
            if(curr.size() > 1) {
                ans.add(List.copyOf(curr));
            }
            return;
        }

        if (curr.isEmpty() || curr.get(curr.size() - 1) <= nums[idx]) {
            curr.add(nums[idx]);
            findSubsequences(curr, nums, idx + 1);
            curr.remove(curr.size() - 1);
        }
        
        findSubsequences(curr, nums, idx + 1);
    }    
}