class Solution {
    int MOD = 1000000007;
    
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int N = locations.length;
        int[][] dp = new int[N][fuel+1];
        Arrays.fill(dp[finish], 1);
        
        for(int f=0; f<=fuel; f++) {
            for(int l=0; l<N; l++) {
                for(int k=0; k<N; k++) {
                    int fuelNeeded = Math.abs(locations[l]-locations[k]);
                    
                    if(k == l || fuelNeeded>f) continue;

                    dp[l][f] = (dp[l][f]+dp[k][f-fuelNeeded])%MOD;
                }
            }
        }
        
        return dp[start][fuel];
    }
    
    public int countRoutes2(int[] locations, int start, int finish, int fuel) {
        int N = locations.length;
        int[][] dp = new int[N][fuel+1];
        
        for(var _dp: dp) Arrays.fill(_dp, -1);
        
        return solve(locations, start, finish, fuel, dp);
    }
    
    private int solve(int[] locations, int city, int end, int fuel, int[][] dp) {
        if(fuel<0) return 0;
        
        if(dp[city][fuel] != -1) return dp[city][fuel];
        
        int cnt = city == end ? 1 : 0;
        
        for(int next=0; next<locations.length; next++) {
            if(next == city) continue;

            int leftFuel = fuel-Math.abs(locations[city]-locations[next]);
                                         
            cnt = (cnt + (solve(locations, next, end, leftFuel, dp)%MOD))%MOD;
        }
        
        return dp[city][fuel]=cnt;
    }
}