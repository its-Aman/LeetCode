class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int N = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
            map.put(nums[i], i);
        }
        
        for(int[] ops: operations) {
            int idx = map.get(ops[0]);
            map.remove(ops[0]);
            map.put(ops[1], idx);
        }
        
        int[] ans = new int[N];
        
        for(int num: map.keySet()) {
            ans[map.get(num)] = num;
        }
        
        return ans;
    }
}