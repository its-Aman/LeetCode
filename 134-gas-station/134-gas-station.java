class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;
        int start = 0;
        int runningFuel = 0;
        int totalFuel = 0;
            
        for(int i = 0; i < N; i++) {
            runningFuel += gas[i] - cost[i];
            totalFuel += gas[i] - cost[i];
            
            if(runningFuel < 0) {
                runningFuel = 0;
                start = i + 1;
            }
        }
        
        return totalFuel < 0 ? -1 : start;
    }
}