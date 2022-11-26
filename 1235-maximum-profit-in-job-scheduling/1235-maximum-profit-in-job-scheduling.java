class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int N = profit.length;
        int[][] jobs = new int[N][3];

        for (int i = 0; i < N; i++)
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};

        Arrays.sort(jobs, Comparator.comparingInt(j -> j[1]));
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);

        for (int[] job : jobs) {
            int currProfit = job[2] + dp.floorEntry(job[0]).getValue();
            if (currProfit > dp.lastEntry().getValue())
                dp.put(job[1], currProfit);
        }

        return dp.lastEntry().getValue();
    }
}