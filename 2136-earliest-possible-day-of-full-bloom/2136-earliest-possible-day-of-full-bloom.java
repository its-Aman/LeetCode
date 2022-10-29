class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int totalDays = 0,
            currPlantTime = 0,
            N = growTime.length;
        
        Queue<Integer> q = 
            new PriorityQueue<>((i, j) -> growTime[j] - growTime[i]);
        
        for(int i = 0; i < N; i++)
            q.offer(i);
        

        while(!q.isEmpty()) {
            int idx = q.poll();
            int time = currPlantTime + plantTime[idx] + growTime[idx];
            totalDays = Math.max(totalDays, time);
            currPlantTime += plantTime[idx];
        }
        
        return totalDays;
    }
}