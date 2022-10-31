class Solution {
    public int coinChange(int[] coins, int amount) {
        int N = coins.length;
        int[] dp = new int[amount + 1];
        
        Arrays.sort(coins);
        Arrays.fill(dp, amount + 1);
        
        dp[0] = 0;
        
        for(int amt = 1; amt <= amount; amt++) {
            
            for(int coin: coins) {
                if(coin > amt) break;
                
                dp[amt] = Math.min(dp[amt], 1 + dp[amt - coin]);
            }
        }
        
        if(dp[amount] > amount)
            return -1;
        
        return dp[amount];
    }
}