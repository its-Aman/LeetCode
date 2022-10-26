class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int N = nums.length, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, sum);
        for(int i = 0; i < N; i++) {
            sum += nums[i];
            
            if(!map.containsKey(sum%k))
                map.put(sum%k, i+1);
            else if(map.get(sum%k) < i)
                return true;
        }
        
        return false;
    }
}