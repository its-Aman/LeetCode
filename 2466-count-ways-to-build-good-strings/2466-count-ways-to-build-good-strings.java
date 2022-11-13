class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        return countGoodStrings_top_down(low, high, zero, one);
    }

    int MOD = 1000000007, ans = 0;

    public int countGoodStrings_top_down(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        int ans = 0;
        
        Arrays.fill(dp, -1);
        
        while(low <= high) {
            ans = (ans + solve(low, dp, one, zero) % MOD) % MOD;
            ++low;
        }
        
        return ans;
        
    }
    
    private int solve(int target, int[] dp, int one, int zero) {
        if(target == 0)
            return 1;
        
        if(target < 0)
            return 0;
        
        if(dp[target] != -1)
            return dp[target];
        
        return dp[target] = ((solve(target - one, dp, one, zero) % MOD) + (solve(target - zero, dp, one, zero) % MOD)) % MOD;
    }

    public int countGoodStrings_bottom_up(int low, int high, int zero, int one) {
        int ans = 0;
        int[] dp = new int[high + 1];
        dp[0] = 1;
        
        for(int i = 1; i <= high; i++) {
            if(i >= zero)
                dp[i] = (dp[i] + dp[i - zero]) % MOD;

            if(i >= one)
                dp[i] = (dp[i] + dp[i - one]) % MOD;
            
            if(i >= low)
                ans = (ans + dp[i]) % MOD;
        }
        
        
        return ans;
    }
}

class Solution2 {
    int MOD = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        return build(0, low, high, zero, one);
    }

    private int build(int currLen, int low, int high, int zero, int one) {
        int x = 0, y = 0;
        if (currLen >= low) {
            x = (1 + (build(currLen + zero, low, high, zero, one) % MOD)) % MOD;

            if (currLen < high)
                y = (1 + (build(currLen + one, low, high, zero, one) % MOD)) % MOD;
        }
        
        return (x + y) % MOD;
    }
}