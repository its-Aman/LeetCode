class Solution {
    public int destroyTargets(int[] nums, int space) {
        /*
        nums[i] + c * space
        */
        
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums)
            map.put(num % space, map.getOrDefault(num % space, 0) + 1);

        for (int key : map.keySet())
            ans = Math.max(ans, map.get(key));

        Arrays.sort(nums);

        for (int num : nums)
            if (map.get(num % space) == ans)
                return num;

        return ans;
    }
}