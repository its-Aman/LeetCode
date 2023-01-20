class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {
        int N = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        
        for(int bitmask = 1; bitmask < (1 << N); bitmask++) {
            List<Integer> curr = new ArrayList<>();
            
            for(int i = 0; i < N; i++) {
                if(((bitmask >> i) & 1) == 1) {
                    curr.add(nums[i]);
                }
            }
            
            if(curr.size() > 1) {
                boolean isIncreasing = true;
                
                for(int i = 0; i < curr.size() - 1; i++) {
                    isIncreasing &= curr.get(i) <= curr.get(i + 1);
                }
                
                if(isIncreasing) {
                    ans.add(curr);
                }
            }
        }
        
        return new ArrayList<>(ans);
    }    
}