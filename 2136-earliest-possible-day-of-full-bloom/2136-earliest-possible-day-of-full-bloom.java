class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int totalDays = 0,
            N = growTime.length;
        List<Integer> indexes = new ArrayList<>();
        
        for(int i = 0; i < N; i++) indexes.add(i);
        
        Collections.sort(indexes, (i, j) -> growTime[j] - growTime[i]);

        for(int i = 0, currPlantTime = 0; i < N; i++) {
            int idx = indexes.get(i);
            int time = currPlantTime + plantTime[idx] + growTime[idx];
            totalDays = Math.max(totalDays, time);
            currPlantTime += plantTime[idx];
        }
        
        return totalDays;
    }
}