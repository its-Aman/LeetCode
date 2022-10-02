class Solution {
    int[][] dp = new int[31][1001];
    
    public int numRollsToTarget2(int n, int k, int target) {
        int MOD = 1000000007;
        
        if(n == 0 || target <= 0)
            return n == target ? 1 : 0;

        if(dp[n][target] != 0)
            return dp[n][target] - 1;
        
        int ans = 0;
        for(int i = 1; i <= k; i++)
            ans = (ans + numRollsToTarget(n - 1, k, target - i)) % MOD;
        
        dp[n][target] = ans + 1;
        return ans;
    }
    
    public int numRollsToTarget(int n, int k, int target) {
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