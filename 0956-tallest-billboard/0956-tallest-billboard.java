class Solution {
    public int tallestBillboard(int[] rods) {
        int N = rods.length, sum = 0;
        
        for(int rod: rods) sum += rod;

        int[][] dp = new int[N+1][sum+1];
        
        for(int i=1; i<=N; i++) {
            for(int j=0; j<sum; j++) {
                if(dp[i-1][j] < j) continue;
                
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                
                int k=j+rods[i-1];
                
                dp[i][k] = Math.max(dp[i][k], dp[i-1][j] + rods[i-1]);
                
                k=Math.abs(j-rods[i-1]);
                
                dp[i][k] = Math.max(dp[i][k], dp[i-1][j] + rods[i-1]);

            }
        }
        
        return dp[N][0]/2;
    }
    
    public int tallestBillboard2(int[] rods) {
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