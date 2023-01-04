class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        
        for(int task: tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        
        for(var key: map.keySet()) {
            int val = map.get(key);
            if(val < 2) {
                return -1;
            }
            
            if(val == 2 || val == 3) {
                ans += 1;
            } else {
                if(val % 3 != 0) {
                    ans += Math.ceil(val / 3) + 1;                
                } else {
                    ans += Math.ceil(val / 3);
                }
            }
        }
        
        return ans;
    }
}