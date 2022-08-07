class Solution {
    public long countBadPairs(int[] nums) {
        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int prev = map.getOrDefault(i - nums[i], 0);
            // counting the current total - good pair. 
            // Rather then doing total - good at the last point, 
            // we're reducing the sum with current index.
            // since total = n*(n-1)/2 = 0+1+2+3+4...n
            // and last we do total - good
            // we're doing here itself in the current eq.
            count += i - prev; 
            map.put(i - nums[i], 1 + prev);
        }
        
        return count;
    }
}