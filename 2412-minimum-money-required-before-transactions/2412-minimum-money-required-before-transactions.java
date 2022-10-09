class Solution {
    public long minimumMoney(int[][] transactions) {
        long maxCashback = 0, minMoney = 0, maxCost = 0;
        
        for(int i = 0; i < transactions.length; i++) {
            if(transactions[i][0] > transactions[i][1]) {
                minMoney += Math.max(0, (long)transactions[i][0] - (long)transactions[i][1]);
                maxCashback = Math.max(maxCashback, (long)transactions[i][1]);
            } else {
                maxCost = Math.max(maxCost, (long)transactions[i][0]);
            }
        }
        
        return minMoney + Math.max(maxCashback, maxCost);
    }
}