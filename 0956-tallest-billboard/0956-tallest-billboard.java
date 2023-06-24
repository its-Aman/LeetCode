class Solution {
    public int tallestBillboard(int[] rods) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0,0);
        
        for(int rod: rods) {
            Map<Integer, Integer> new_dp = new HashMap<>(dp);
            
            for(var entry: dp.entrySet()) {
                int diff = entry.getKey();
                int taller = entry.getValue();
                int shorter = taller - diff;
                
                int newTaller = new_dp.getOrDefault(diff+rod, 0);
                new_dp.put(diff+rod, Math.max(newTaller, taller+rod));
                
                int newDiff = Math.abs(shorter+rod-taller);
                int newTaller2 = Math.max(shorter+rod, taller);
                new_dp.put(newDiff, Math.max(newTaller2, new_dp.getOrDefault(newDiff, 0)));
            }
            
            dp=new_dp;
        }
        
        return dp.getOrDefault(0,0);
    }
}