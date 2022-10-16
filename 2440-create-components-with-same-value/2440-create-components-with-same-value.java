class Solution {
    Map<Integer, List<Integer>> g = new HashMap<>();

    public int componentValue(int[] nums, int[][] edges) {
        
        for(var e: edges) {
            g.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        
        int sum = 0;
        int[] temp;
        
        for(int num: nums)
            sum += num;
        
        for(int i = nums.length; i > 1; i--) {
            if(sum % i != 0)
                continue;
        
            temp = new int[nums.length];
            
            if(traverse(nums, 0, temp, sum / i) == 0)
                return i-1;
        }
        
        return 0;
    }
    
    private int traverse(int[] nums, int curr, int[] temp, int target) {
        temp[curr] = nums[curr];
        
        for(var next: g.getOrDefault(curr, new ArrayList<>())) {
            if(temp[next] != 0)
                continue;
            
            temp[curr] += traverse(nums, next, temp, target);
            
            if(temp[curr] > target)
                return 1000000007;
        }
        
        if(temp[curr] == target)
            return 0;
        
        return temp[curr];
    }
}