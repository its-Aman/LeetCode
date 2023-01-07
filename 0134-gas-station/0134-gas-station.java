class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length,
            runningFuel = 0,
            idx = 0,
            totalGas = 0;
        
        for(int i = 0; i < N; i++) {
            int currNeed = gas[i] - cost[i];
            runningFuel += currNeed;
            totalGas += currNeed;
            
            if(runningFuel < 0) {
                runningFuel = 0;
                idx = i + 1;
            }
        }
        
        if(totalGas < 0) {
            return -1;
        }
        
        return idx;
    }
}