class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int N = plantTime.length;
        int[][] days = new int[N][2];
        
        for(int i = 0; i < N; i++)
            days[i] = new int[]{growTime[i], plantTime[i]};
        
        Arrays.sort(days, Comparator.comparing(d -> -d[0]));
        
        int plantSum = 0, totalDays = 0;
        
        for(int[] day: days) {
            int grow = day[0],
                plant = day[1];

            totalDays = Math.max(totalDays, plantSum + grow + plant);
            plantSum += plant;
        }
        
        return totalDays;
    }
}