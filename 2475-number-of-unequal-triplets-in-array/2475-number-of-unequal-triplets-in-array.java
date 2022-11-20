class Solution {
    public int unequalTriplets(int[] nums) {
        int N = nums.length;
        int ans = 0, left = 0, right = N;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n: nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        
        for(int k: map.keySet()) {
            int cnt = map.get(k);
            right -= cnt;
            ans += left * cnt * right;
            left += cnt;
        }
            
        return ans;
    }
}