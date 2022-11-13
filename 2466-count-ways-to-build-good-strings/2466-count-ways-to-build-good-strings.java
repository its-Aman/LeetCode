class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int MOD = 1000000007, ans = 0;
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