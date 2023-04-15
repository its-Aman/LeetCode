class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        
        for(int num: nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        
        for(int key: cnt.keySet()) {
            if(cnt.get(key)*2 > nums.length) {
                return key;
            }
        }
        
        return -1;
    }
}