class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int max = 0;
        
        for(int num: nums)
            set.add(num);
        
        for(int num: set) {
            int currMax = map.getOrDefault(num - 1, 0) + 1 + map.getOrDefault(num + 1, 0);
            max = Math.max(max, currMax);
            
            map.put(num, currMax);
            map.put(num - map.getOrDefault(num - 1, 0), currMax);
            map.put(num + map.getOrDefault(num + 1, 0), currMax);
        }
        
        return max;
    }
}