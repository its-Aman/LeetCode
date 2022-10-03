class Solution {
    
    public int numRollsToTarget(int dice, int face, int target) {
        int MOD = 1000000007;
        int[] dp = new int[target + 1];
        
        if(dice == 0 || target <= 0)
            return dice == target ? 1 : 0;
        
        dp[0] = 1;
            
        for(int d = 1; d <= dice; d++) {
            int[] next = new int[target + 1];
            int prev = dp[0];
            
            for(int t = 1;  t <= target; t++) {
                next[t] = prev;
                prev = (prev + dp[t]) % MOD;
                
                if(t - face >= 0)
                    prev = (prev - dp[t - face] + MOD) % MOD;
            }
            
            dp = next;
        }

        return dp[target];
    }
    
    public int numRollsToTarget2(int n, int k, int target) {
        int MOD = 1000000007;
        int[] dp = new int[target + 1];
        
        dp[0] = 1;
        
        for(int i = 1; i <= n; i++) {
            int[] next = new int[target + 1];

            for(int j = 1; j <= k; j++)
                for(int t = j; t <= target; t++)
                    next[t] = (next[t] + dp[t - j]) % MOD;
            
            dp = next;
        }

        return dp[target] % MOD;
    }
}